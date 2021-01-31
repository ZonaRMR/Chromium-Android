// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/wire/feed/action_type.proto

package com.google.search.now.wire.feed;

public final class ActionTypeProto {
  private ActionTypeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  /**
   * <pre>
   * The specific action that was performed on an feature described by a ContentId
   * and SemanticProperties.
   * </pre>
   *
   * Protobuf enum {@code search.now.wire.feed.ActionType}
   */
  public enum ActionType
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <code>UNKNOWN_ACTION_TYPE = 0;</code>
     */
    UNKNOWN_ACTION_TYPE(0),
    /**
     * <code>DISMISS = 1;</code>
     */
    DISMISS(1),
    ;

    /**
     * <code>UNKNOWN_ACTION_TYPE = 0;</code>
     */
    public static final int UNKNOWN_ACTION_TYPE_VALUE = 0;
    /**
     * <code>DISMISS = 1;</code>
     */
    public static final int DISMISS_VALUE = 1;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ActionType valueOf(int value) {
      return forNumber(value);
    }

    public static ActionType forNumber(int value) {
      switch (value) {
        case 0: return UNKNOWN_ACTION_TYPE;
        case 1: return DISMISS;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ActionType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ActionType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ActionType>() {
            public ActionType findValueByNumber(int number) {
              return ActionType.forNumber(number);
            }
          };

    private final int value;

    ActionType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:search.now.wire.feed.ActionType)
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
