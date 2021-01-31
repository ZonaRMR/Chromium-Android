// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.infobar;


/**
 * Functions needed to display an InfoBar UI.
 */
public interface InfoBarView extends InfoBarContainerLayout.Item {
    /**
     * Prepares the InfoBar for display and adds InfoBar-specific controls to the layout.
     * @param layout Layout containing all of the controls.
     */
    void createContent(InfoBarLayout layout);

    /**
     * Takes some action related to the link being clicked.
     */
    void onLinkClicked();

    /**
     * Takes some action related to the close button being clicked.
     */
    void onCloseButtonClicked();

    /**
     * Performs some action related to either the primary or secondary button being pressed.
     * @param isPrimaryButton True if the primary button was clicked, false otherwise.
     */
    void onButtonClicked(boolean isPrimaryButton);
}
