/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ml.shifu.shifu.util;

import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Base64UtilsTest class
 * 
 * @Nov 18, 2014
 *
 */
public class Base64UtilsTest {

    @Test
    public void testBase64() throws IOException {
        String testStr = "fkjasfjksadlfjksadljlgjpsaogjowgjoawjeoewriopwepoqpeokqfkapwokfpaowkfpowekfpawkpfowefweofkweo\n"
                + "ksjfklasjfklsadjfksadfjklsadjfklsadjfksadfoiwghiewriweuriweoruowerwerwerweorweporiweporiwpeoripweori\n"
                + "我们的事情 快速的分解开撒娇福克斯的副教授==============================================================asdfasdfsdf \r"
                + "It's wired!!!! why not truncated!";
        
        String encodeStr = Base64Utils.base64Encode(testStr);
        System.out.println(encodeStr);
        String decodeStr = Base64Utils.base64Decode(encodeStr);
        
        Assert.assertEquals(testStr, decodeStr);
    }

    @Test
    public void testBase64Delimiter() throws IOException {
        String testStr = "\u0007";

        String encodeStr = Base64Utils.base64Encode(testStr);
        System.out.println(encodeStr);
        String decodeStr = Base64Utils.base64Decode(encodeStr);

        Assert.assertEquals(testStr, decodeStr);
        System.out.println("\\u0007");
        System.out.println("\\\\t");

        System.out.println(Base64Utils.base64Decode("|"));
    }
    
}
