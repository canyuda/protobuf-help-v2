// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: util/util.proto

package com.test.proto.util;

public final class UtilProto {
  private UtilProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface CMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:CMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string error_message = 1;</code>
     */
    boolean hasErrorMessage();
    /**
     * <code>optional string error_message = 1;</code>
     */
    java.lang.String getErrorMessage();
    /**
     * <code>optional string error_message = 1;</code>
     */
    com.google.protobuf.ByteString
        getErrorMessageBytes();

    /**
     * <code>optional string hint_message = 2;</code>
     */
    boolean hasHintMessage();
    /**
     * <code>optional string hint_message = 2;</code>
     */
    java.lang.String getHintMessage();
    /**
     * <code>optional string hint_message = 2;</code>
     */
    com.google.protobuf.ByteString
        getHintMessageBytes();
  }
  /**
   * Protobuf type {@code CMessage}
   */
  public  static final class CMessage extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:CMessage)
      CMessageOrBuilder {
    // Use CMessage.newBuilder() to construct.
    private CMessage(com.google.protobuf.GeneratedMessage.Builder builder) {
      super(builder);
    }
    private CMessage() {
      errorMessage_ = "";
      hintMessage_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private CMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              errorMessage_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              hintMessage_ = bs;
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.test.proto.util.UtilProto.internal_static_CMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.test.proto.util.UtilProto.internal_static_CMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.test.proto.util.UtilProto.CMessage.class, com.test.proto.util.UtilProto.CMessage.Builder.class);
    }

    private int bitField0_;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 1;
    private volatile java.lang.Object errorMessage_;
    /**
     * <code>optional string error_message = 1;</code>
     */
    public boolean hasErrorMessage() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string error_message = 1;</code>
     */
    public java.lang.String getErrorMessage() {
      java.lang.Object ref = errorMessage_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          errorMessage_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string error_message = 1;</code>
     */
    public com.google.protobuf.ByteString
        getErrorMessageBytes() {
      java.lang.Object ref = errorMessage_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        errorMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int HINT_MESSAGE_FIELD_NUMBER = 2;
    private volatile java.lang.Object hintMessage_;
    /**
     * <code>optional string hint_message = 2;</code>
     */
    public boolean hasHintMessage() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string hint_message = 2;</code>
     */
    public java.lang.String getHintMessage() {
      java.lang.Object ref = hintMessage_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          hintMessage_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string hint_message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHintMessageBytes() {
      java.lang.Object ref = hintMessage_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hintMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getErrorMessageBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getHintMessageBytes());
      }
      unknownFields.writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getErrorMessageBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getHintMessageBytes());
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.test.proto.util.UtilProto.CMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.test.proto.util.UtilProto.CMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.test.proto.util.UtilProto.CMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.test.proto.util.UtilProto.CMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code CMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:CMessage)
        com.test.proto.util.UtilProto.CMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.test.proto.util.UtilProto.internal_static_CMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.test.proto.util.UtilProto.internal_static_CMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.test.proto.util.UtilProto.CMessage.class, com.test.proto.util.UtilProto.CMessage.Builder.class);
      }

      // Construct using com.test.proto.util.UtilProto.CMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        errorMessage_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        hintMessage_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.test.proto.util.UtilProto.internal_static_CMessage_descriptor;
      }

      public com.test.proto.util.UtilProto.CMessage getDefaultInstanceForType() {
        return com.test.proto.util.UtilProto.CMessage.getDefaultInstance();
      }

      public com.test.proto.util.UtilProto.CMessage build() {
        com.test.proto.util.UtilProto.CMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.test.proto.util.UtilProto.CMessage buildPartial() {
        com.test.proto.util.UtilProto.CMessage result = new com.test.proto.util.UtilProto.CMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.errorMessage_ = errorMessage_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.hintMessage_ = hintMessage_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.test.proto.util.UtilProto.CMessage) {
          return mergeFrom((com.test.proto.util.UtilProto.CMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.test.proto.util.UtilProto.CMessage other) {
        if (other == com.test.proto.util.UtilProto.CMessage.getDefaultInstance()) return this;
        if (other.hasErrorMessage()) {
          bitField0_ |= 0x00000001;
          errorMessage_ = other.errorMessage_;
          onChanged();
        }
        if (other.hasHintMessage()) {
          bitField0_ |= 0x00000002;
          hintMessage_ = other.hintMessage_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.test.proto.util.UtilProto.CMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.test.proto.util.UtilProto.CMessage) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object errorMessage_ = "";
      /**
       * <code>optional string error_message = 1;</code>
       */
      public boolean hasErrorMessage() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string error_message = 1;</code>
       */
      public java.lang.String getErrorMessage() {
        java.lang.Object ref = errorMessage_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            errorMessage_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string error_message = 1;</code>
       */
      public com.google.protobuf.ByteString
          getErrorMessageBytes() {
        java.lang.Object ref = errorMessage_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          errorMessage_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string error_message = 1;</code>
       */
      public Builder setErrorMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        errorMessage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string error_message = 1;</code>
       */
      public Builder clearErrorMessage() {
        bitField0_ = (bitField0_ & ~0x00000001);
        errorMessage_ = getDefaultInstance().getErrorMessage();
        onChanged();
        return this;
      }
      /**
       * <code>optional string error_message = 1;</code>
       */
      public Builder setErrorMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        errorMessage_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object hintMessage_ = "";
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public boolean hasHintMessage() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public java.lang.String getHintMessage() {
        java.lang.Object ref = hintMessage_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            hintMessage_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public com.google.protobuf.ByteString
          getHintMessageBytes() {
        java.lang.Object ref = hintMessage_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          hintMessage_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public Builder setHintMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        hintMessage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public Builder clearHintMessage() {
        bitField0_ = (bitField0_ & ~0x00000002);
        hintMessage_ = getDefaultInstance().getHintMessage();
        onChanged();
        return this;
      }
      /**
       * <code>optional string hint_message = 2;</code>
       */
      public Builder setHintMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        hintMessage_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:CMessage)
    }

    // @@protoc_insertion_point(class_scope:CMessage)
    private static final com.test.proto.util.UtilProto.CMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.test.proto.util.UtilProto.CMessage();
    }

    public static com.test.proto.util.UtilProto.CMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    public static final com.google.protobuf.Parser<CMessage> PARSER =
        new com.google.protobuf.AbstractParser<CMessage>() {
      public CMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new CMessage(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<CMessage> getParserForType() {
      return PARSER;
    }

    public com.test.proto.util.UtilProto.CMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_CMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_CMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017util/util.proto\"7\n\010CMessage\022\025\n\rerror_m" +
      "essage\030\001 \001(\t\022\024\n\014hint_message\030\002 \001(\tB&\n\023co" +
      "m.test.proto.utilB\tUtilProto\242\002\003GBP"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_CMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_CMessage_descriptor,
        new java.lang.String[] { "ErrorMessage", "HintMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
