/*
 * Copyright 2015 Kevin Herron
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.Identifiers;
import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaRequestMessage;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;

@UaDataType("CloseSessionRequest")
public class CloseSessionRequest implements UaRequestMessage {

    public static final NodeId TypeId = Identifiers.CloseSessionRequest;
    public static final NodeId BinaryEncodingId = Identifiers.CloseSessionRequest_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.CloseSessionRequest_Encoding_DefaultXml;

    protected final RequestHeader _requestHeader;
    protected final Boolean _deleteSubscriptions;

    public CloseSessionRequest() {
        this._requestHeader = null;
        this._deleteSubscriptions = null;
    }

    public CloseSessionRequest(RequestHeader _requestHeader, Boolean _deleteSubscriptions) {
        this._requestHeader = _requestHeader;
        this._deleteSubscriptions = _deleteSubscriptions;
    }

    public RequestHeader getRequestHeader() {
        return _requestHeader;
    }

    public Boolean getDeleteSubscriptions() {
        return _deleteSubscriptions;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(CloseSessionRequest closeSessionRequest, UaEncoder encoder) {
        encoder.encodeSerializable("RequestHeader", closeSessionRequest._requestHeader != null ? closeSessionRequest._requestHeader : new RequestHeader());
        encoder.encodeBoolean("DeleteSubscriptions", closeSessionRequest._deleteSubscriptions);
    }

    public static CloseSessionRequest decode(UaDecoder decoder) {
        RequestHeader _requestHeader = decoder.decodeSerializable("RequestHeader", RequestHeader.class);
        Boolean _deleteSubscriptions = decoder.decodeBoolean("DeleteSubscriptions");

        return new CloseSessionRequest(_requestHeader, _deleteSubscriptions);
    }

    static {
        DelegateRegistry.registerEncoder(CloseSessionRequest::encode, CloseSessionRequest.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(CloseSessionRequest::decode, CloseSessionRequest.class, BinaryEncodingId, XmlEncodingId);
    }

}
