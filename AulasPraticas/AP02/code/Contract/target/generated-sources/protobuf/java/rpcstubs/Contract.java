// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: contract.proto

package rpcstubs;

public final class Contract {
  private Contract() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Void_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Void_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Initial_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Initial_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_FinalPoint_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_FinalPoint_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_Payment_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_Payment_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_baseservice_WarnMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_baseservice_WarnMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016contract.proto\022\013baseservice\"\006\n\004Void\"&\n" +
      "\007Initial\022\n\n\002Id\030\001 \001(\t\022\017\n\007inPoint\030\002 \001(\005\"*\n" +
      "\nFinalPoint\022\n\n\002Id\030\001 \001(\t\022\020\n\010outPoint\030\002 \001(" +
      "\005\"\030\n\007Payment\022\r\n\005value\030\001 \001(\002\"&\n\007WarnMsg\022\n" +
      "\n\002Id\030\001 \001(\t\022\017\n\007warning\030\002 \001(\t2\265\001\n\016ControlS" +
      "ervice\0220\n\005Enter\022\024.baseservice.Initial\032\021." +
      "baseservice.Void\0229\n\007Warning\022\024.baseservic" +
      "e.WarnMsg\032\024.baseservice.WarnMsg(\0010\001\0226\n\005L" +
      "eave\022\027.baseservice.FinalPoint\032\024.baseserv" +
      "ice.PaymentB\014\n\010rpcstubsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_baseservice_Void_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_baseservice_Void_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Void_descriptor,
        new java.lang.String[] { });
    internal_static_baseservice_Initial_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_baseservice_Initial_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Initial_descriptor,
        new java.lang.String[] { "Id", "InPoint", });
    internal_static_baseservice_FinalPoint_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_baseservice_FinalPoint_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_FinalPoint_descriptor,
        new java.lang.String[] { "Id", "OutPoint", });
    internal_static_baseservice_Payment_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_baseservice_Payment_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_Payment_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_baseservice_WarnMsg_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_baseservice_WarnMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_baseservice_WarnMsg_descriptor,
        new java.lang.String[] { "Id", "Warning", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
