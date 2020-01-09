// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: base/resp.proto

package com.test.proto.base;

public final class RespProto {
  private RespProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface BaseResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:BaseResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 error_code = 1;</code>
     */
    boolean hasErrorCode();
    /**
     * <code>optional int32 error_code = 1;</code>
     */
    int getErrorCode();

    /**
     * <code>optional .CMessage message = 2;</code>
     */
    boolean hasMessage();
    /**
     * <code>optional .CMessage message = 2;</code>
     */
    com.test.proto.util.UtilProto.CMessage getMessage();
    /**
     * <code>optional .CMessage message = 2;</code>
     */
    com.test.proto.util.UtilProto.CMessageOrBuilder getMessageOrBuilder();
  }
  /**
   * Protobuf type {@code BaseResponse}
   */
  public  static final class BaseResponse extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:BaseResponse)
      BaseResponseOrBuilder {
    // Use BaseResponse.newBuilder() to construct.
    private BaseResponse(com.google.protobuf.GeneratedMessage.Builder builder) {
      super(builder);
    }
    private BaseResponse() {
      errorCode_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private BaseResponse(
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
            case 8: {
              bitField0_ |= 0x00000001;
              errorCode_ = input.readInt32();
              break;
            }
            case 18: {
              com.test.proto.util.UtilProto.CMessage.Builder subBuilder = null;
              if (((bitField0_ & 0x00000002) == 0x00000002)) {
                subBuilder = message_.toBuilder();
              }
              message_ = input.readMessage(com.test.proto.util.UtilProto.CMessage.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(message_);
                message_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000002;
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
      return com.test.proto.base.RespProto.internal_static_BaseResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.test.proto.base.RespProto.internal_static_BaseResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.test.proto.base.RespProto.BaseResponse.class, com.test.proto.base.RespProto.BaseResponse.Builder.class);
    }

    private int bitField0_;
    public static final int ERROR_CODE_FIELD_NUMBER = 1;
    private int errorCode_;
    /**
     * <code>optional int32 error_code = 1;</code>
     */
    public boolean hasErrorCode() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 error_code = 1;</code>
     */
    public int getErrorCode() {
      return errorCode_;
    }

    public static final int MESSAGE_FIELD_NUMBER = 2;
    private com.test.proto.util.UtilProto.CMessage message_;
    /**
     * <code>optional .CMessage message = 2;</code>
     */
    public boolean hasMessage() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .CMessage message = 2;</code>
     */
    public com.test.proto.util.UtilProto.CMessage getMessage() {
      return message_ == null ? com.test.proto.util.UtilProto.CMessage.getDefaultInstance() : message_;
    }
    /**
     * <code>optional .CMessage message = 2;</code>
     */
    public com.test.proto.util.UtilProto.CMessageOrBuilder getMessageOrBuilder() {
      return message_ == null ? com.test.proto.util.UtilProto.CMessage.getDefaultInstance() : message_;
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
        output.writeInt32(1, errorCode_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeMessage(2, getMessage());
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
          .computeInt32Size(1, errorCode_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getMessage());
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.test.proto.base.RespProto.BaseResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.test.proto.base.RespProto.BaseResponse prototype) {
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
     * Protobuf type {@code BaseResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:BaseResponse)
        com.test.proto.base.RespProto.BaseResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.test.proto.base.RespProto.internal_static_BaseResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.test.proto.base.RespProto.internal_static_BaseResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.test.proto.base.RespProto.BaseResponse.class, com.test.proto.base.RespProto.BaseResponse.Builder.class);
      }

      // Construct using com.test.proto.base.RespProto.BaseResponse.newBuilder()
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
          getMessageFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        errorCode_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        if (messageBuilder_ == null) {
          message_ = null;
        } else {
          messageBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.test.proto.base.RespProto.internal_static_BaseResponse_descriptor;
      }

      public com.test.proto.base.RespProto.BaseResponse getDefaultInstanceForType() {
        return com.test.proto.base.RespProto.BaseResponse.getDefaultInstance();
      }

      public com.test.proto.base.RespProto.BaseResponse build() {
        com.test.proto.base.RespProto.BaseResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.test.proto.base.RespProto.BaseResponse buildPartial() {
        com.test.proto.base.RespProto.BaseResponse result = new com.test.proto.base.RespProto.BaseResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.errorCode_ = errorCode_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        if (messageBuilder_ == null) {
          result.message_ = message_;
        } else {
          result.message_ = messageBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.test.proto.base.RespProto.BaseResponse) {
          return mergeFrom((com.test.proto.base.RespProto.BaseResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.test.proto.base.RespProto.BaseResponse other) {
        if (other == com.test.proto.base.RespProto.BaseResponse.getDefaultInstance()) return this;
        if (other.hasErrorCode()) {
          setErrorCode(other.getErrorCode());
        }
        if (other.hasMessage()) {
          mergeMessage(other.getMessage());
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
        com.test.proto.base.RespProto.BaseResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.test.proto.base.RespProto.BaseResponse) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int errorCode_ ;
      /**
       * <code>optional int32 error_code = 1;</code>
       */
      public boolean hasErrorCode() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional int32 error_code = 1;</code>
       */
      public int getErrorCode() {
        return errorCode_;
      }
      /**
       * <code>optional int32 error_code = 1;</code>
       */
      public Builder setErrorCode(int value) {
        bitField0_ |= 0x00000001;
        errorCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 error_code = 1;</code>
       */
      public Builder clearErrorCode() {
        bitField0_ = (bitField0_ & ~0x00000001);
        errorCode_ = 0;
        onChanged();
        return this;
      }

      private com.test.proto.util.UtilProto.CMessage message_ = null;
      private com.google.protobuf.SingleFieldBuilder<
          com.test.proto.util.UtilProto.CMessage, com.test.proto.util.UtilProto.CMessage.Builder, com.test.proto.util.UtilProto.CMessageOrBuilder> messageBuilder_;
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public boolean hasMessage() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public com.test.proto.util.UtilProto.CMessage getMessage() {
        if (messageBuilder_ == null) {
          return message_ == null ? com.test.proto.util.UtilProto.CMessage.getDefaultInstance() : message_;
        } else {
          return messageBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public Builder setMessage(com.test.proto.util.UtilProto.CMessage value) {
        if (messageBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          message_ = value;
          onChanged();
        } else {
          messageBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public Builder setMessage(
          com.test.proto.util.UtilProto.CMessage.Builder builderForValue) {
        if (messageBuilder_ == null) {
          message_ = builderForValue.build();
          onChanged();
        } else {
          messageBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public Builder mergeMessage(com.test.proto.util.UtilProto.CMessage value) {
        if (messageBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002) &&
              message_ != null &&
              message_ != com.test.proto.util.UtilProto.CMessage.getDefaultInstance()) {
            message_ =
              com.test.proto.util.UtilProto.CMessage.newBuilder(message_).mergeFrom(value).buildPartial();
          } else {
            message_ = value;
          }
          onChanged();
        } else {
          messageBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000002;
        return this;
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public Builder clearMessage() {
        if (messageBuilder_ == null) {
          message_ = null;
          onChanged();
        } else {
          messageBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public com.test.proto.util.UtilProto.CMessage.Builder getMessageBuilder() {
        bitField0_ |= 0x00000002;
        onChanged();
        return getMessageFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      public com.test.proto.util.UtilProto.CMessageOrBuilder getMessageOrBuilder() {
        if (messageBuilder_ != null) {
          return messageBuilder_.getMessageOrBuilder();
        } else {
          return message_ == null ?
              com.test.proto.util.UtilProto.CMessage.getDefaultInstance() : message_;
        }
      }
      /**
       * <code>optional .CMessage message = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          com.test.proto.util.UtilProto.CMessage, com.test.proto.util.UtilProto.CMessage.Builder, com.test.proto.util.UtilProto.CMessageOrBuilder> 
          getMessageFieldBuilder() {
        if (messageBuilder_ == null) {
          messageBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              com.test.proto.util.UtilProto.CMessage, com.test.proto.util.UtilProto.CMessage.Builder, com.test.proto.util.UtilProto.CMessageOrBuilder>(
                  getMessage(),
                  getParentForChildren(),
                  isClean());
          message_ = null;
        }
        return messageBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:BaseResponse)
    }

    // @@protoc_insertion_point(class_scope:BaseResponse)
    private static final com.test.proto.base.RespProto.BaseResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.test.proto.base.RespProto.BaseResponse();
    }

    public static com.test.proto.base.RespProto.BaseResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    public static final com.google.protobuf.Parser<BaseResponse> PARSER =
        new com.google.protobuf.AbstractParser<BaseResponse>() {
      public BaseResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new BaseResponse(input, extensionRegistry);
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
    public com.google.protobuf.Parser<BaseResponse> getParserForType() {
      return PARSER;
    }

    public com.test.proto.base.RespProto.BaseResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_BaseResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_BaseResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017base/resp.proto\032\017util/util.proto\">\n\014Ba" +
      "seResponse\022\022\n\nerror_code\030\001 \001(\005\022\032\n\007messag" +
      "e\030\002 \001(\0132\t.CMessageB&\n\023com.test.proto.bas" +
      "eB\tRespProto\242\002\003GBP"
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
          com.test.proto.util.UtilProto.getDescriptor(),
        }, assigner);
    internal_static_BaseResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BaseResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_BaseResponse_descriptor,
        new java.lang.String[] { "ErrorCode", "Message", });
    com.test.proto.util.UtilProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}