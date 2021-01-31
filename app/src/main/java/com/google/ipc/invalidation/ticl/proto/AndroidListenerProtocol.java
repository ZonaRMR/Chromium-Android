/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by j/c/g/ipc/invalidation/common/proto_wrapper_generator
package com.google.ipc.invalidation.ticl.proto;

import com.google.ipc.invalidation.util.Bytes;
import com.google.ipc.invalidation.util.ProtoWrapper;
import com.google.ipc.invalidation.util.ProtoWrapper.ValidationException;
import com.google.ipc.invalidation.util.TextBuilder;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public interface AndroidListenerProtocol {

  final class AndroidListenerState extends ProtoWrapper {
    public static final class RetryRegistrationState extends ProtoWrapper {
      public static RetryRegistrationState create(com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP objectId,
          com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState exponentialBackoffState) {
        return new RetryRegistrationState(objectId, exponentialBackoffState);
      }

      public static final RetryRegistrationState DEFAULT_INSTANCE = new RetryRegistrationState(null, null);

      private final long __hazzerBits;
      private final com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP objectId;
      private final com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState exponentialBackoffState;

      private RetryRegistrationState(com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP objectId,
          com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState exponentialBackoffState) {
        int hazzerBits = 0;
        this.objectId = objectId;
        if (exponentialBackoffState != null) {
          hazzerBits |= 0x1;
          this.exponentialBackoffState = exponentialBackoffState;
        } else {
          this.exponentialBackoffState = com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState.DEFAULT_INSTANCE;
        }
        this.__hazzerBits = hazzerBits;
      }

      public com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP getNullableObjectId() { return objectId; }

      public com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState getExponentialBackoffState() { return exponentialBackoffState; }
      public boolean hasExponentialBackoffState() { return (0x1 & __hazzerBits) != 0; }

      @Override public final boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof RetryRegistrationState)) { return false; }
        RetryRegistrationState other = (RetryRegistrationState) obj;
        return __hazzerBits == other.__hazzerBits
            && equals(objectId, other.objectId)
            && (!hasExponentialBackoffState() || equals(exponentialBackoffState, other.exponentialBackoffState));
      }

      @Override protected int computeHashCode() {
        int result = hash(__hazzerBits);
        if (objectId != null) {
          result = result * 31 + objectId.hashCode();
        }
        if (hasExponentialBackoffState()) {
          result = result * 31 + exponentialBackoffState.hashCode();
        }
        return result;
      }

      @Override public void toCompactString(TextBuilder builder) {
        builder.append("<RetryRegistrationState:");
        if (objectId != null) {
          builder.append(" object_id=").append(objectId);
        }
        if (hasExponentialBackoffState()) {
          builder.append(" exponential_backoff_state=").append(exponentialBackoffState);
        }
        builder.append('>');
      }

      public static RetryRegistrationState parseFrom(byte[] data) throws ValidationException {
        try {
          return fromMessageNano(MessageNano.mergeFrom(new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState(), data));
        } catch (InvalidProtocolBufferNanoException exception) {
          throw new ValidationException(exception);
        } catch (ValidationArgumentException exception) {
          throw new ValidationException(exception.getMessage());
        }
      }

      static RetryRegistrationState fromMessageNano(com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState message) {
        if (message == null) { return null; }
        return new RetryRegistrationState(com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP.fromMessageNano(message.objectId),
            com.google.ipc.invalidation.ticl.proto.Client.ExponentialBackoffState.fromMessageNano(message.exponentialBackoffState));
      }

      public byte[] toByteArray() {
        return MessageNano.toByteArray(toMessageNano());
      }

      com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState toMessageNano() {
        com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState msg = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState();
        msg.objectId = this.objectId != null ? objectId.toMessageNano() : null;
        msg.exponentialBackoffState = hasExponentialBackoffState() ? exponentialBackoffState.toMessageNano() : null;
        return msg;
      }
    }
    public static final class ScheduledRegistrationRetry extends ProtoWrapper {
      public static ScheduledRegistrationRetry create(com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand command,
          Long executeTimeMs) {
        return new ScheduledRegistrationRetry(command, executeTimeMs);
      }

      public static final ScheduledRegistrationRetry DEFAULT_INSTANCE = new ScheduledRegistrationRetry(null, null);

      private final long __hazzerBits;
      private final com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand command;
      private final long executeTimeMs;

      private ScheduledRegistrationRetry(com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand command,
          Long executeTimeMs) {
        int hazzerBits = 0;
        if (command != null) {
          hazzerBits |= 0x1;
          this.command = command;
        } else {
          this.command = com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand.DEFAULT_INSTANCE;
        }
        if (executeTimeMs != null) {
          hazzerBits |= 0x2;
          this.executeTimeMs = executeTimeMs;
        } else {
          this.executeTimeMs = 0;
        }
        this.__hazzerBits = hazzerBits;
      }

      public com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand getCommand() { return command; }
      public boolean hasCommand() { return (0x1 & __hazzerBits) != 0; }

      public long getExecuteTimeMs() { return executeTimeMs; }
      public boolean hasExecuteTimeMs() { return (0x2 & __hazzerBits) != 0; }

      @Override public final boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof ScheduledRegistrationRetry)) { return false; }
        ScheduledRegistrationRetry other = (ScheduledRegistrationRetry) obj;
        return __hazzerBits == other.__hazzerBits
            && (!hasCommand() || equals(command, other.command))
            && (!hasExecuteTimeMs() || executeTimeMs == other.executeTimeMs);
      }

      @Override protected int computeHashCode() {
        int result = hash(__hazzerBits);
        if (hasCommand()) {
          result = result * 31 + command.hashCode();
        }
        if (hasExecuteTimeMs()) {
          result = result * 31 + hash(executeTimeMs);
        }
        return result;
      }

      @Override public void toCompactString(TextBuilder builder) {
        builder.append("<ScheduledRegistrationRetry:");
        if (hasCommand()) {
          builder.append(" command=").append(command);
        }
        if (hasExecuteTimeMs()) {
          builder.append(" execute_time_ms=").append(executeTimeMs);
        }
        builder.append('>');
      }

      public static ScheduledRegistrationRetry parseFrom(byte[] data) throws ValidationException {
        try {
          return fromMessageNano(MessageNano.mergeFrom(new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry(), data));
        } catch (InvalidProtocolBufferNanoException exception) {
          throw new ValidationException(exception);
        } catch (ValidationArgumentException exception) {
          throw new ValidationException(exception.getMessage());
        }
      }

      static ScheduledRegistrationRetry fromMessageNano(com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry message) {
        if (message == null) { return null; }
        return new ScheduledRegistrationRetry(com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.RegistrationCommand.fromMessageNano(message.command),
            message.executeTimeMs);
      }

      public byte[] toByteArray() {
        return MessageNano.toByteArray(toMessageNano());
      }

      com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry toMessageNano() {
        com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry msg = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry();
        msg.command = hasCommand() ? command.toMessageNano() : null;
        msg.executeTimeMs = hasExecuteTimeMs() ? executeTimeMs : null;
        return msg;
      }
    }
    public static AndroidListenerState create(Collection<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> registration,
        Collection<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState> retryRegistrationState,
        Bytes clientId,
        Integer requestCodeSeqNum,
        Collection<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry> registrationRetry) {
      return new AndroidListenerState(registration, retryRegistrationState, clientId, requestCodeSeqNum, registrationRetry);
    }

    public static final AndroidListenerState DEFAULT_INSTANCE = new AndroidListenerState(null, null, null, null, null);

    private final long __hazzerBits;
    private final List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> registration;
    private final List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState> retryRegistrationState;
    private final Bytes clientId;
    private final int requestCodeSeqNum;
    private final List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry> registrationRetry;

    private AndroidListenerState(Collection<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> registration,
        Collection<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState> retryRegistrationState,
        Bytes clientId,
        Integer requestCodeSeqNum,
        Collection<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry> registrationRetry) {
      int hazzerBits = 0;
      this.registration = optional("registration", registration);
      this.retryRegistrationState = optional("retry_registration_state", retryRegistrationState);
      if (clientId != null) {
        hazzerBits |= 0x1;
        this.clientId = clientId;
      } else {
        this.clientId = Bytes.EMPTY_BYTES;
      }
      if (requestCodeSeqNum != null) {
        hazzerBits |= 0x2;
        this.requestCodeSeqNum = requestCodeSeqNum;
      } else {
        this.requestCodeSeqNum = 0;
      }
      this.registrationRetry = optional("registration_retry", registrationRetry);
      this.__hazzerBits = hazzerBits;
    }

    public List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> getRegistration() { return registration; }

    public List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState> getRetryRegistrationState() { return retryRegistrationState; }

    public Bytes getClientId() { return clientId; }
    public boolean hasClientId() { return (0x1 & __hazzerBits) != 0; }

    public int getRequestCodeSeqNum() { return requestCodeSeqNum; }
    public boolean hasRequestCodeSeqNum() { return (0x2 & __hazzerBits) != 0; }

    public List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry> getRegistrationRetry() { return registrationRetry; }

    @Override public final boolean equals(Object obj) {
      if (this == obj) { return true; }
      if (!(obj instanceof AndroidListenerState)) { return false; }
      AndroidListenerState other = (AndroidListenerState) obj;
      return __hazzerBits == other.__hazzerBits
          && equals(registration, other.registration)
          && equals(retryRegistrationState, other.retryRegistrationState)
          && (!hasClientId() || equals(clientId, other.clientId))
          && (!hasRequestCodeSeqNum() || requestCodeSeqNum == other.requestCodeSeqNum)
          && equals(registrationRetry, other.registrationRetry);
    }

    @Override protected int computeHashCode() {
      int result = hash(__hazzerBits);
      result = result * 31 + registration.hashCode();
      result = result * 31 + retryRegistrationState.hashCode();
      if (hasClientId()) {
        result = result * 31 + clientId.hashCode();
      }
      if (hasRequestCodeSeqNum()) {
        result = result * 31 + hash(requestCodeSeqNum);
      }
      result = result * 31 + registrationRetry.hashCode();
      return result;
    }

    @Override public void toCompactString(TextBuilder builder) {
      builder.append("<AndroidListenerState:");
      builder.append(" registration=[").append(registration).append(']');
      builder.append(" retry_registration_state=[").append(retryRegistrationState).append(']');
      if (hasClientId()) {
        builder.append(" client_id=").append(clientId);
      }
      if (hasRequestCodeSeqNum()) {
        builder.append(" request_code_seq_num=").append(requestCodeSeqNum);
      }
      builder.append(" registration_retry=[").append(registrationRetry).append(']');
      builder.append('>');
    }

    public static AndroidListenerState parseFrom(byte[] data) throws ValidationException {
      try {
        return fromMessageNano(MessageNano.mergeFrom(new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState(), data));
      } catch (InvalidProtocolBufferNanoException exception) {
        throw new ValidationException(exception);
      } catch (ValidationArgumentException exception) {
        throw new ValidationException(exception.getMessage());
      }
    }

    static AndroidListenerState fromMessageNano(com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState message) {
      if (message == null) { return null; }
      List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> registration = new ArrayList<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP>(message.registration.length);
      for (int i = 0; i < message.registration.length; i++) {
        registration.add(com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP.fromMessageNano(message.registration[i]));
      }
      List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState> retryRegistrationState = new ArrayList<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState>(message.retryRegistrationState.length);
      for (int i = 0; i < message.retryRegistrationState.length; i++) {
        retryRegistrationState.add(com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.RetryRegistrationState.fromMessageNano(message.retryRegistrationState[i]));
      }
      List<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry> registrationRetry = new ArrayList<com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry>(message.registrationRetry.length);
      for (int i = 0; i < message.registrationRetry.length; i++) {
        registrationRetry.add(com.google.ipc.invalidation.ticl.proto.AndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry.fromMessageNano(message.registrationRetry[i]));
      }
      return new AndroidListenerState(registration,
          retryRegistrationState,
          Bytes.fromByteArray(message.clientId),
          message.requestCodeSeqNum,
          registrationRetry);
    }

    public byte[] toByteArray() {
      return MessageNano.toByteArray(toMessageNano());
    }

    com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState toMessageNano() {
      com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState msg = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState();
      msg.registration = new com.google.protos.ipc.invalidation.nano.NanoClientProtocol.ObjectIdP[registration.size()];
      for (int i = 0; i < msg.registration.length; i++) {
        msg.registration[i] = registration.get(i).toMessageNano();
      }
      msg.retryRegistrationState = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.RetryRegistrationState[retryRegistrationState.size()];
      for (int i = 0; i < msg.retryRegistrationState.length; i++) {
        msg.retryRegistrationState[i] = retryRegistrationState.get(i).toMessageNano();
      }
      msg.clientId = hasClientId() ? clientId.getByteArray() : null;
      msg.requestCodeSeqNum = hasRequestCodeSeqNum() ? requestCodeSeqNum : null;
      msg.registrationRetry = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.AndroidListenerState.ScheduledRegistrationRetry[registrationRetry.size()];
      for (int i = 0; i < msg.registrationRetry.length; i++) {
        msg.registrationRetry[i] = registrationRetry.get(i).toMessageNano();
      }
      return msg;
    }
  }

  final class RegistrationCommand extends ProtoWrapper {
    public static RegistrationCommand create(Boolean isRegister,
        Collection<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> objectId,
        Bytes clientId,
        Boolean isDelayed) {
      return new RegistrationCommand(isRegister, objectId, clientId, isDelayed);
    }

    public static final RegistrationCommand DEFAULT_INSTANCE = new RegistrationCommand(null, null, null, null);

    private final long __hazzerBits;
    private final boolean isRegister;
    private final List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> objectId;
    private final Bytes clientId;
    private final boolean isDelayed;

    private RegistrationCommand(Boolean isRegister,
        Collection<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> objectId,
        Bytes clientId,
        Boolean isDelayed) {
      int hazzerBits = 0;
      if (isRegister != null) {
        hazzerBits |= 0x1;
        this.isRegister = isRegister;
      } else {
        this.isRegister = false;
      }
      this.objectId = optional("object_id", objectId);
      if (clientId != null) {
        hazzerBits |= 0x2;
        this.clientId = clientId;
      } else {
        this.clientId = Bytes.EMPTY_BYTES;
      }
      if (isDelayed != null) {
        hazzerBits |= 0x4;
        this.isDelayed = isDelayed;
      } else {
        this.isDelayed = false;
      }
      this.__hazzerBits = hazzerBits;
    }

    public boolean getIsRegister() { return isRegister; }
    public boolean hasIsRegister() { return (0x1 & __hazzerBits) != 0; }

    public List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> getObjectId() { return objectId; }

    public Bytes getClientId() { return clientId; }
    public boolean hasClientId() { return (0x2 & __hazzerBits) != 0; }

    public boolean getIsDelayed() { return isDelayed; }
    public boolean hasIsDelayed() { return (0x4 & __hazzerBits) != 0; }

    @Override public final boolean equals(Object obj) {
      if (this == obj) { return true; }
      if (!(obj instanceof RegistrationCommand)) { return false; }
      RegistrationCommand other = (RegistrationCommand) obj;
      return __hazzerBits == other.__hazzerBits
          && (!hasIsRegister() || isRegister == other.isRegister)
          && equals(objectId, other.objectId)
          && (!hasClientId() || equals(clientId, other.clientId))
          && (!hasIsDelayed() || isDelayed == other.isDelayed);
    }

    @Override protected int computeHashCode() {
      int result = hash(__hazzerBits);
      if (hasIsRegister()) {
        result = result * 31 + hash(isRegister);
      }
      result = result * 31 + objectId.hashCode();
      if (hasClientId()) {
        result = result * 31 + clientId.hashCode();
      }
      if (hasIsDelayed()) {
        result = result * 31 + hash(isDelayed);
      }
      return result;
    }

    @Override public void toCompactString(TextBuilder builder) {
      builder.append("<RegistrationCommand:");
      if (hasIsRegister()) {
        builder.append(" is_register=").append(isRegister);
      }
      builder.append(" object_id=[").append(objectId).append(']');
      if (hasClientId()) {
        builder.append(" client_id=").append(clientId);
      }
      if (hasIsDelayed()) {
        builder.append(" is_delayed=").append(isDelayed);
      }
      builder.append('>');
    }

    public static RegistrationCommand parseFrom(byte[] data) throws ValidationException {
      try {
        return fromMessageNano(MessageNano.mergeFrom(new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.RegistrationCommand(), data));
      } catch (InvalidProtocolBufferNanoException exception) {
        throw new ValidationException(exception);
      } catch (ValidationArgumentException exception) {
        throw new ValidationException(exception.getMessage());
      }
    }

    static RegistrationCommand fromMessageNano(com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.RegistrationCommand message) {
      if (message == null) { return null; }
      List<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP> objectId = new ArrayList<com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP>(message.objectId.length);
      for (int i = 0; i < message.objectId.length; i++) {
        objectId.add(com.google.ipc.invalidation.ticl.proto.ClientProtocol.ObjectIdP.fromMessageNano(message.objectId[i]));
      }
      return new RegistrationCommand(message.isRegister,
          objectId,
          Bytes.fromByteArray(message.clientId),
          message.isDelayed);
    }

    public byte[] toByteArray() {
      return MessageNano.toByteArray(toMessageNano());
    }

    com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.RegistrationCommand toMessageNano() {
      com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.RegistrationCommand msg = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.RegistrationCommand();
      msg.isRegister = hasIsRegister() ? isRegister : null;
      msg.objectId = new com.google.protos.ipc.invalidation.nano.NanoClientProtocol.ObjectIdP[objectId.size()];
      for (int i = 0; i < msg.objectId.length; i++) {
        msg.objectId[i] = objectId.get(i).toMessageNano();
      }
      msg.clientId = hasClientId() ? clientId.getByteArray() : null;
      msg.isDelayed = hasIsDelayed() ? isDelayed : null;
      return msg;
    }
  }

  final class StartCommand extends ProtoWrapper {
    public static StartCommand create(Integer clientType,
        Bytes clientName,
        Boolean allowSuppression) {
      return new StartCommand(clientType, clientName, allowSuppression);
    }

    public static final StartCommand DEFAULT_INSTANCE = new StartCommand(null, null, null);

    private final long __hazzerBits;
    private final int clientType;
    private final Bytes clientName;
    private final boolean allowSuppression;

    private StartCommand(Integer clientType,
        Bytes clientName,
        Boolean allowSuppression) {
      int hazzerBits = 0;
      if (clientType != null) {
        hazzerBits |= 0x1;
        this.clientType = clientType;
      } else {
        this.clientType = 0;
      }
      if (clientName != null) {
        hazzerBits |= 0x2;
        this.clientName = clientName;
      } else {
        this.clientName = Bytes.EMPTY_BYTES;
      }
      if (allowSuppression != null) {
        hazzerBits |= 0x4;
        this.allowSuppression = allowSuppression;
      } else {
        this.allowSuppression = false;
      }
      this.__hazzerBits = hazzerBits;
    }

    public int getClientType() { return clientType; }
    public boolean hasClientType() { return (0x1 & __hazzerBits) != 0; }

    public Bytes getClientName() { return clientName; }
    public boolean hasClientName() { return (0x2 & __hazzerBits) != 0; }

    public boolean getAllowSuppression() { return allowSuppression; }
    public boolean hasAllowSuppression() { return (0x4 & __hazzerBits) != 0; }

    @Override public final boolean equals(Object obj) {
      if (this == obj) { return true; }
      if (!(obj instanceof StartCommand)) { return false; }
      StartCommand other = (StartCommand) obj;
      return __hazzerBits == other.__hazzerBits
          && (!hasClientType() || clientType == other.clientType)
          && (!hasClientName() || equals(clientName, other.clientName))
          && (!hasAllowSuppression() || allowSuppression == other.allowSuppression);
    }

    @Override protected int computeHashCode() {
      int result = hash(__hazzerBits);
      if (hasClientType()) {
        result = result * 31 + hash(clientType);
      }
      if (hasClientName()) {
        result = result * 31 + clientName.hashCode();
      }
      if (hasAllowSuppression()) {
        result = result * 31 + hash(allowSuppression);
      }
      return result;
    }

    @Override public void toCompactString(TextBuilder builder) {
      builder.append("<StartCommand:");
      if (hasClientType()) {
        builder.append(" client_type=").append(clientType);
      }
      if (hasClientName()) {
        builder.append(" client_name=").append(clientName);
      }
      if (hasAllowSuppression()) {
        builder.append(" allow_suppression=").append(allowSuppression);
      }
      builder.append('>');
    }

    public static StartCommand parseFrom(byte[] data) throws ValidationException {
      try {
        return fromMessageNano(MessageNano.mergeFrom(new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.StartCommand(), data));
      } catch (InvalidProtocolBufferNanoException exception) {
        throw new ValidationException(exception);
      } catch (ValidationArgumentException exception) {
        throw new ValidationException(exception.getMessage());
      }
    }

    static StartCommand fromMessageNano(com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.StartCommand message) {
      if (message == null) { return null; }
      return new StartCommand(message.clientType,
          Bytes.fromByteArray(message.clientName),
          message.allowSuppression);
    }

    public byte[] toByteArray() {
      return MessageNano.toByteArray(toMessageNano());
    }

    com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.StartCommand toMessageNano() {
      com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.StartCommand msg = new com.google.protos.ipc.invalidation.NanoAndroidListenerProtocol.StartCommand();
      msg.clientType = hasClientType() ? clientType : null;
      msg.clientName = hasClientName() ? clientName.getByteArray() : null;
      msg.allowSuppression = hasAllowSuppression() ? allowSuppression : null;
      return msg;
    }
  }
}
