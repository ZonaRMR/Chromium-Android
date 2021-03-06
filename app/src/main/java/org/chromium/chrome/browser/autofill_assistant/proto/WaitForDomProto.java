// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package org.chromium.chrome.browser.autofill_assistant.proto;

/**
 * <pre>
 * Ask Chrome to wait for an element in the DOM. This can be used to only
 * proceed to the next action once the page is ready.
 * </pre>
 *
 * Protobuf type {@code autofill_assistant.WaitForDomProto}
 */
public  final class WaitForDomProto extends
    com.google.protobuf.GeneratedMessageLite<
        WaitForDomProto, WaitForDomProto.Builder> implements
    // @@protoc_insertion_point(message_implements:autofill_assistant.WaitForDomProto)
    WaitForDomProtoOrBuilder {
  private WaitForDomProto() {
    selectors_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
  }
  private int bitField0_;
  public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
  private int timeoutMs_;
  /**
   * <pre>
   * Fail after waiting this amount of time.
   * </pre>
   *
   * <code>optional int32 timeout_ms = 1;</code>
   */
  public boolean hasTimeoutMs() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * Fail after waiting this amount of time.
   * </pre>
   *
   * <code>optional int32 timeout_ms = 1;</code>
   */
  public int getTimeoutMs() {
    return timeoutMs_;
  }
  /**
   * <pre>
   * Fail after waiting this amount of time.
   * </pre>
   *
   * <code>optional int32 timeout_ms = 1;</code>
   */
  private void setTimeoutMs(int value) {
    bitField0_ |= 0x00000001;
    timeoutMs_ = value;
  }
  /**
   * <pre>
   * Fail after waiting this amount of time.
   * </pre>
   *
   * <code>optional int32 timeout_ms = 1;</code>
   */
  private void clearTimeoutMs() {
    bitField0_ = (bitField0_ & ~0x00000001);
    timeoutMs_ = 0;
  }

  public static final int SELECTORS_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.ProtobufList<String> selectors_;
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  public java.util.List<String> getSelectorsList() {
    return selectors_;
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  public int getSelectorsCount() {
    return selectors_.size();
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  public java.lang.String getSelectors(int index) {
    return selectors_.get(index);
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSelectorsBytes(int index) {
    return com.google.protobuf.ByteString.copyFromUtf8(
        selectors_.get(index));
  }
  private void ensureSelectorsIsMutable() {
    if (!selectors_.isModifiable()) {
      selectors_ =
          com.google.protobuf.GeneratedMessageLite.mutableCopy(selectors_);
     }
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  private void setSelectors(
      int index, java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  ensureSelectorsIsMutable();
    selectors_.set(index, value);
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  private void addSelectors(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  ensureSelectorsIsMutable();
    selectors_.add(value);
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  private void addAllSelectors(
      java.lang.Iterable<java.lang.String> values) {
    ensureSelectorsIsMutable();
    com.google.protobuf.AbstractMessageLite.addAll(
        values, selectors_);
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  private void clearSelectors() {
    selectors_ = com.google.protobuf.GeneratedMessageLite.emptyProtobufList();
  }
  /**
   * <pre>
   * The element to wait for.
   * TODO(crbug.com/806868): Use ElementReferenceProto instead.
   * </pre>
   *
   * <code>repeated string selectors = 2;</code>
   */
  private void addSelectorsBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  ensureSelectorsIsMutable();
    selectors_.add(value.toStringUtf8());
  }

  public static final int ALLOW_INTERRUPT_FIELD_NUMBER = 3;
  private boolean allowInterrupt_;
  /**
   * <pre>
   * If true, run scripts flagged with 'interrupt=true' as soon as their
   * preconditions match.
   * </pre>
   *
   * <code>optional bool allow_interrupt = 3;</code>
   */
  public boolean hasAllowInterrupt() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * If true, run scripts flagged with 'interrupt=true' as soon as their
   * preconditions match.
   * </pre>
   *
   * <code>optional bool allow_interrupt = 3;</code>
   */
  public boolean getAllowInterrupt() {
    return allowInterrupt_;
  }
  /**
   * <pre>
   * If true, run scripts flagged with 'interrupt=true' as soon as their
   * preconditions match.
   * </pre>
   *
   * <code>optional bool allow_interrupt = 3;</code>
   */
  private void setAllowInterrupt(boolean value) {
    bitField0_ |= 0x00000002;
    allowInterrupt_ = value;
  }
  /**
   * <pre>
   * If true, run scripts flagged with 'interrupt=true' as soon as their
   * preconditions match.
   * </pre>
   *
   * <code>optional bool allow_interrupt = 3;</code>
   */
  private void clearAllowInterrupt() {
    bitField0_ = (bitField0_ & ~0x00000002);
    allowInterrupt_ = false;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeInt32(1, timeoutMs_);
    }
    for (int i = 0; i < selectors_.size(); i++) {
      output.writeString(2, selectors_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeBool(3, allowInterrupt_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, timeoutMs_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < selectors_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeStringSizeNoTag(selectors_.get(i));
      }
      size += dataSize;
      size += 1 * getSelectorsList().size();
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, allowInterrupt_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  /**
   * <pre>
   * Ask Chrome to wait for an element in the DOM. This can be used to only
   * proceed to the next action once the page is ready.
   * </pre>
   *
   * Protobuf type {@code autofill_assistant.WaitForDomProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto, Builder> implements
      // @@protoc_insertion_point(builder_implements:autofill_assistant.WaitForDomProto)
      org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProtoOrBuilder {
    // Construct using org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * Fail after waiting this amount of time.
     * </pre>
     *
     * <code>optional int32 timeout_ms = 1;</code>
     */
    public boolean hasTimeoutMs() {
      return instance.hasTimeoutMs();
    }
    /**
     * <pre>
     * Fail after waiting this amount of time.
     * </pre>
     *
     * <code>optional int32 timeout_ms = 1;</code>
     */
    public int getTimeoutMs() {
      return instance.getTimeoutMs();
    }
    /**
     * <pre>
     * Fail after waiting this amount of time.
     * </pre>
     *
     * <code>optional int32 timeout_ms = 1;</code>
     */
    public Builder setTimeoutMs(int value) {
      copyOnWrite();
      instance.setTimeoutMs(value);
      return this;
    }
    /**
     * <pre>
     * Fail after waiting this amount of time.
     * </pre>
     *
     * <code>optional int32 timeout_ms = 1;</code>
     */
    public Builder clearTimeoutMs() {
      copyOnWrite();
      instance.clearTimeoutMs();
      return this;
    }

    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public java.util.List<String>
        getSelectorsList() {
      return java.util.Collections.unmodifiableList(
          instance.getSelectorsList());
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public int getSelectorsCount() {
      return instance.getSelectorsCount();
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public java.lang.String getSelectors(int index) {
      return instance.getSelectors(index);
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSelectorsBytes(int index) {
      return instance.getSelectorsBytes(index);
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public Builder setSelectors(
        int index, java.lang.String value) {
      copyOnWrite();
      instance.setSelectors(index, value);
      return this;
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public Builder addSelectors(
        java.lang.String value) {
      copyOnWrite();
      instance.addSelectors(value);
      return this;
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public Builder addAllSelectors(
        java.lang.Iterable<java.lang.String> values) {
      copyOnWrite();
      instance.addAllSelectors(values);
      return this;
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public Builder clearSelectors() {
      copyOnWrite();
      instance.clearSelectors();
      return this;
    }
    /**
     * <pre>
     * The element to wait for.
     * TODO(crbug.com/806868): Use ElementReferenceProto instead.
     * </pre>
     *
     * <code>repeated string selectors = 2;</code>
     */
    public Builder addSelectorsBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.addSelectorsBytes(value);
      return this;
    }

    /**
     * <pre>
     * If true, run scripts flagged with 'interrupt=true' as soon as their
     * preconditions match.
     * </pre>
     *
     * <code>optional bool allow_interrupt = 3;</code>
     */
    public boolean hasAllowInterrupt() {
      return instance.hasAllowInterrupt();
    }
    /**
     * <pre>
     * If true, run scripts flagged with 'interrupt=true' as soon as their
     * preconditions match.
     * </pre>
     *
     * <code>optional bool allow_interrupt = 3;</code>
     */
    public boolean getAllowInterrupt() {
      return instance.getAllowInterrupt();
    }
    /**
     * <pre>
     * If true, run scripts flagged with 'interrupt=true' as soon as their
     * preconditions match.
     * </pre>
     *
     * <code>optional bool allow_interrupt = 3;</code>
     */
    public Builder setAllowInterrupt(boolean value) {
      copyOnWrite();
      instance.setAllowInterrupt(value);
      return this;
    }
    /**
     * <pre>
     * If true, run scripts flagged with 'interrupt=true' as soon as their
     * preconditions match.
     * </pre>
     *
     * <code>optional bool allow_interrupt = 3;</code>
     */
    public Builder clearAllowInterrupt() {
      copyOnWrite();
      instance.clearAllowInterrupt();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:autofill_assistant.WaitForDomProto)
  }
  protected final Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      Object arg0, Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto();
      }
      case IS_INITIALIZED: {
        return DEFAULT_INSTANCE;
      }
      case MAKE_IMMUTABLE: {
        selectors_.makeImmutable();
        return null;
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case VISIT: {
        Visitor visitor = (Visitor) arg0;
        org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto other = (org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto) arg1;
        timeoutMs_ = visitor.visitInt(
            hasTimeoutMs(), timeoutMs_,
            other.hasTimeoutMs(), other.timeoutMs_);
        selectors_= visitor.visitList(selectors_, other.selectors_);
        allowInterrupt_ = visitor.visitBoolean(
            hasAllowInterrupt(), allowInterrupt_,
            other.hasAllowInterrupt(), other.allowInterrupt_);
        if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
            .INSTANCE) {
          bitField0_ |= other.bitField0_;
        }
        return this;
      }
      case MERGE_FROM_STREAM: {
        com.google.protobuf.CodedInputStream input =
            (com.google.protobuf.CodedInputStream) arg0;
        com.google.protobuf.ExtensionRegistryLite extensionRegistry =
            (com.google.protobuf.ExtensionRegistryLite) arg1;
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              default: {
                if (!parseUnknownField(tag, input)) {
                  done = true;
                }
                break;
              }
              case 8: {
                bitField0_ |= 0x00000001;
                timeoutMs_ = input.readInt32();
                break;
              }
              case 18: {
                String s = input.readString();
                if (!selectors_.isModifiable()) {
                  selectors_ =
                      com.google.protobuf.GeneratedMessageLite.mutableCopy(selectors_);
                }
                selectors_.add(s);
                break;
              }
              case 24: {
                bitField0_ |= 0x00000002;
                allowInterrupt_ = input.readBool();
                break;
              }
            }
          }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw new RuntimeException(e.setUnfinishedMessage(this));
        } catch (java.io.IOException e) {
          throw new RuntimeException(
              new com.google.protobuf.InvalidProtocolBufferException(
                  e.getMessage()).setUnfinishedMessage(this));
        } finally {
        }
      }
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        if (PARSER == null) {    synchronized (org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto.class) {
            if (PARSER == null) {
              PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
            }
          }
        }
        return PARSER;
      }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:autofill_assistant.WaitForDomProto)
  private static final org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new WaitForDomProto();
    DEFAULT_INSTANCE.makeImmutable();
  }

  public static org.chromium.chrome.browser.autofill_assistant.proto.WaitForDomProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<WaitForDomProto> PARSER;

  public static com.google.protobuf.Parser<WaitForDomProto> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

