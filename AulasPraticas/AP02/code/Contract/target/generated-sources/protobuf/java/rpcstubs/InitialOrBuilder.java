// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: contract.proto

package rpcstubs;

public interface InitialOrBuilder extends
    // @@protoc_insertion_point(interface_extends:baseservice.Initial)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *matricula do veículo
   * </pre>
   *
   * <code>string Id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   *matricula do veículo
   * </pre>
   *
   * <code>string Id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * ponto de entrada
   * </pre>
   *
   * <code>int32 inPoint = 2;</code>
   * @return The inPoint.
   */
  int getInPoint();
}