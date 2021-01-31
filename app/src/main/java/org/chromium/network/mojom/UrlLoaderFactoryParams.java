
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_context.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class UrlLoaderFactoryParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int processId;
    public org.chromium.url.mojom.Origin requestInitiatorSiteLock;
    public boolean isCorbEnabled;
    public int corbDetachableResourceType;
    public int corbExcludedResourceType;
    public boolean disableWebSecurity;
    public TrustedUrlLoaderHeaderClient headerClient;

    private UrlLoaderFactoryParams(int version) {
        super(STRUCT_SIZE, version);
        this.processId = NetworkContextConstants.INVALID_PROCESS_ID;
        this.isCorbEnabled = true;
        this.corbDetachableResourceType = (int) -1L;
        this.corbExcludedResourceType = (int) -1L;
        this.disableWebSecurity = false;
    }

    public UrlLoaderFactoryParams() {
        this(0);
    }

    public static UrlLoaderFactoryParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static UrlLoaderFactoryParams deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static UrlLoaderFactoryParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        UrlLoaderFactoryParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new UrlLoaderFactoryParams(elementsOrVersion);
                {
                    
                result.processId = decoder0.readInt(8);
                }
                {
                    
                result.isCorbEnabled = decoder0.readBoolean(12, 0);
                }
                {
                    
                result.disableWebSecurity = decoder0.readBoolean(12, 1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                result.requestInitiatorSiteLock = org.chromium.url.mojom.Origin.decode(decoder1);
                }
                {
                    
                result.corbDetachableResourceType = decoder0.readInt(24);
                }
                {
                    
                result.corbExcludedResourceType = decoder0.readInt(28);
                }
                {
                    
                result.headerClient = decoder0.readServiceInterface(32, true, TrustedUrlLoaderHeaderClient.MANAGER);
                }

        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.processId, 8);
        
        encoder0.encode(this.isCorbEnabled, 12, 0);
        
        encoder0.encode(this.disableWebSecurity, 12, 1);
        
        encoder0.encode(this.requestInitiatorSiteLock, 16, true);
        
        encoder0.encode(this.corbDetachableResourceType, 24);
        
        encoder0.encode(this.corbExcludedResourceType, 28);
        
        encoder0.encode(this.headerClient, 32, true, TrustedUrlLoaderHeaderClient.MANAGER);
    }
}