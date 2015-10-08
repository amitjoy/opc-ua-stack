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

package com.digitalpetri.opcua.stack;

import com.digitalpetri.opcua.stack.core.channel.headers.SequenceHeader;
import com.google.common.primitives.UnsignedInteger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SequenceHeaderTest extends SerializationFixture2 {

    @DataProvider(name = "parameters")
    public Object[][] getParameters() {
        return new Object[][]{
                {0, 0},
                {Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE + 1L, Integer.MAX_VALUE + 1L},
                {UnsignedInteger.MAX_VALUE.longValue(), UnsignedInteger.MAX_VALUE.longValue()}
        };
    }

    @Test(dataProvider = "parameters", description = "SequenceHeader is serializable.")
    public void testSerialization(long sequenceNumber, long requestId) {
        SequenceHeader header = new SequenceHeader(sequenceNumber, requestId);

        assertSerializable(header, SequenceHeader::encode, SequenceHeader::decode);
    }

}
