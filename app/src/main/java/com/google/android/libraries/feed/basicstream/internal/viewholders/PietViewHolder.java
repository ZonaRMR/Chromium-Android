// Copyright 2018 The Feed Authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.android.libraries.feed.basicstream.internal.viewholders;

import static com.google.android.libraries.feed.common.Validators.checkNotNull;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.google.android.libraries.feed.api.actionparser.ActionParser;
import com.google.android.libraries.feed.common.logging.Logger;
import com.google.android.libraries.feed.common.ui.LayoutUtils;
import com.google.android.libraries.feed.host.action.StreamActionApi;
import com.google.android.libraries.feed.host.config.Configuration;
import com.google.android.libraries.feed.host.stream.CardConfiguration;
import com.google.android.libraries.feed.piet.FrameAdapter;
import com.google.android.libraries.feed.piet.PietManager;
import com.google.android.libraries.feed.piet.host.ActionHandler.ActionType;
import com.google.android.libraries.feed.sharedstream.logging.LoggingListener;
import com.google.android.libraries.feed.sharedstream.logging.VisibilityMonitor;
import com.google.search.now.ui.action.FeedActionPayloadProto.FeedActionPayload;
import com.google.search.now.ui.piet.PietAndroidSupport.ShardingControl;
import com.google.search.now.ui.piet.PietProto.Frame;
import com.google.search.now.ui.piet.PietProto.PietSharedState;
import java.util.List;

/**
 * {@link android.support.v7.widget.RecyclerView.ViewHolder} for {@link
 * com.google.search.now.ui.stream.StreamStructureProto.PietContent}.
 */
public class PietViewHolder extends FeedViewHolder implements SwipeableViewHolder {

  private static final String TAG = "PietViewHolder";
  private final CardConfiguration cardConfiguration;
  private final FrameLayout cardView;
  private final FrameAdapter frameAdapter;
  private final VisibilityMonitor visibilityMonitor;
  private boolean bound;

  /*@Nullable*/ private ActionParser actionParser;
  /*@Nullable*/ private LoggingListener loggingListener;
  /*@Nullable*/ private StreamActionApi streamActionApi;
  /*@Nullable*/ private FeedActionPayload swipeAction;

  public PietViewHolder(
      CardConfiguration cardConfiguration,
      FrameLayout cardView,
      PietManager pietManager,
      Context context,
      Configuration configuration) {
    super(cardView);
    this.cardConfiguration = cardConfiguration;
    this.cardView = cardView;
    cardView.setId(R.id.feed_content_card);
    this.frameAdapter =
        pietManager.createPietFrameAdapter(
            () -> cardView,
            (action, actionType, frame, view, veLoggingToken) -> {
              if (actionParser == null) {
                Logger.wtf(TAG, "Action being performed while unbound.");
                return;
              }

              if (actionType == ActionType.CLICK) {
                getLoggingListener().onContentClicked();
              }
              getActionParser().parseAction(action, getStreamActionApi(), view, veLoggingToken);
            },
            errorCodes -> {},
            context);
    visibilityMonitor = createVisibilityMonitor(cardView, configuration);
    cardView.addView(frameAdapter.getFrameContainer());
  }

  public void bind(
      Frame frame,
      List<PietSharedState> pietSharedStates,
      StreamActionApi streamActionApi,
      FeedActionPayload swipeAction,
      LoggingListener loggingListener,
      ActionParser actionParser) {
    if (bound) {
      return;
    }
    visibilityMonitor.setListener(loggingListener);
    this.loggingListener = loggingListener;
    this.streamActionApi = streamActionApi;
    this.swipeAction = swipeAction;
    this.actionParser = actionParser;

    // Need to reset padding here.  Setting a background can affect padding so if we switch from
    // a background which has padding to one that does not, then the padding needs to be removed.
    cardView.setPadding(0, 0, 0, 0);

    cardView.setBackground(cardConfiguration.getCardBackground());

    ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
    if (layoutParams == null) {
      layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
      cardView.setLayoutParams(layoutParams);
    } else if (!(layoutParams instanceof MarginLayoutParams)) {
      layoutParams = new LayoutParams(layoutParams);
      cardView.setLayoutParams(layoutParams);
    }
    LayoutUtils.setMarginsRelative(
        (MarginLayoutParams) layoutParams,
        cardConfiguration.getCardStartMargin(),
        0,
        cardConfiguration.getCardEndMargin(),
        cardConfiguration.getCardBottomMargin());

    frameAdapter.bindModel(
        frame,
        0, // TODO: set the frame width here
            null,
        pietSharedStates);
    bound = true;
  }

  @Override
  public void unbind() {
    if (!bound) {
      return;
    }

    actionParser = null;
    loggingListener = null;
    streamActionApi = null;
    swipeAction = null;
    visibilityMonitor.setListener(null);
    frameAdapter.unbindModel();
    bound = false;
  }

  public boolean canSwipe() {
    return swipeAction != null && !swipeAction.equals(FeedActionPayload.getDefaultInstance());
  }

  @Override
  public void onSwiped() {
    if (swipeAction == null || actionParser == null) {
      Logger.wtf(TAG, "Swipe performed on unbound ViewHolder.");
      return;
    }
    actionParser.parseFeedActionPayload(swipeAction, getStreamActionApi(), itemView);

    if (loggingListener == null) {
      Logger.wtf(TAG, "Logging listener is null. Swipe perfomred on unbound ViewHolder.");
      return;
    }
    loggingListener.onContentSwiped();
  }

  @VisibleForTesting
  VisibilityMonitor createVisibilityMonitor(
      /*@UnderInitialization*/ PietViewHolder this, View view, Configuration configuration) {
    return new VisibilityMonitor(view, configuration);
  }

  private LoggingListener getLoggingListener(/*@UnknownInitialization*/ PietViewHolder this) {
    return checkNotNull(
        loggingListener, "Logging listener can only be retrieved once view holder has been bound.");
  }

  private StreamActionApi getStreamActionApi(/*@UnknownInitialization*/ PietViewHolder this) {
    return checkNotNull(
        streamActionApi,
        "Stream action api can only be retrieved once view holder has been bound.");
  }

  private ActionParser getActionParser(/*@UnknownInitialization*/ PietViewHolder this) {
    return checkNotNull(
        actionParser, "Action parser can only be retrieved once view holder has been bound");
  }
}
