// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.google.protos.ipc.invalidation.nano;

// @@protoc_insertion_point(imports_scope)

@SuppressWarnings("hiding")
public interface NanoChannelCommon {

  final class ChannelMessageEncoding extends
      com.google.protobuf.nano.ExtendableMessageNano<ChannelMessageEncoding> {

    // enum MessageEncoding
    public static final int PROTOBUF_BINARY_FORMAT = 1;

    private static volatile ChannelMessageEncoding[] _emptyArray;
    public static ChannelMessageEncoding[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new ChannelMessageEncoding[0];
          }
        }
      }
      return _emptyArray;
    }

    // @@protoc_insertion_point(class_scope:com.google.protos.ipc.invalidation.ChannelMessageEncoding)

    public ChannelMessageEncoding() {
      clear();
    }

    public ChannelMessageEncoding clear() {
      unknownFieldData = null;
      cachedSize = -1;
      return this;
    }

    @Override
    public ChannelMessageEncoding mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!super.storeUnknownField(input, tag)) {
              return this;
            }
            break;
          }
        }
      }
    }

    public static ChannelMessageEncoding parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new ChannelMessageEncoding(), data);
    }

    public static ChannelMessageEncoding parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new ChannelMessageEncoding().mergeFrom(input);
    }
  }

  final class NetworkEndpointId extends
      com.google.protobuf.nano.ExtendableMessageNano<NetworkEndpointId> {

    // enum NetworkAddress
    public static final int TEST = 1;
    public static final int ANDROID = 113;
    public static final int LCS = 114;

    private static volatile NetworkEndpointId[] _emptyArray;
    public static NetworkEndpointId[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new NetworkEndpointId[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional .com.google.protos.ipc.invalidation.NetworkEndpointId.NetworkAddress network_address = 1;
    public java.lang.Integer networkAddress;

    // optional bytes client_address = 2;
    public byte[] clientAddress;

    // optional bool is_offline = 3;
    public java.lang.Boolean isOffline;

    // @@protoc_insertion_point(class_scope:com.google.protos.ipc.invalidation.NetworkEndpointId)

    public NetworkEndpointId() {
      clear();
    }

    public NetworkEndpointId clear() {
      networkAddress = null;
      clientAddress = null;
      isOffline = null;
      unknownFieldData = null;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.networkAddress != null) {
        output.writeInt32(1, this.networkAddress);
      }
      if (this.clientAddress != null) {
        output.writeBytes(2, this.clientAddress);
      }
      if (this.isOffline != null) {
        output.writeBool(3, this.isOffline);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.networkAddress != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(1, this.networkAddress);
      }
      if (this.clientAddress != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBytesSize(2, this.clientAddress);
      }
      if (this.isOffline != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(3, this.isOffline);
      }
      return size;
    }

    @Override
    public NetworkEndpointId mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!super.storeUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            int initialPos = input.getPosition();
            int value = input.readInt32();
            switch (value) {
              case com.google.protos.ipc.invalidation.nano.NanoChannelCommon.NetworkEndpointId.TEST:
              case com.google.protos.ipc.invalidation.nano.NanoChannelCommon.NetworkEndpointId.ANDROID:
              case com.google.protos.ipc.invalidation.nano.NanoChannelCommon.NetworkEndpointId.LCS:
                this.networkAddress = value;
                break;
              default:
                input.rewindToPosition(initialPos);
                storeUnknownField(input, tag);
                break;
            }
            break;
          }
          case 18: {
            this.clientAddress = input.readBytes();
            break;
          }
          case 24: {
            this.isOffline = input.readBool();
            break;
          }
        }
      }
    }

    public static NetworkEndpointId parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new NetworkEndpointId(), data);
    }

    public static NetworkEndpointId parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new NetworkEndpointId().mergeFrom(input);
    }
  }
}
