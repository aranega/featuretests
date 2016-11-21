/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.model.config;

import java.util.Properties;

/**
 * Retrieves API Key Id and Secret from Environment Variables
 *
 * @author af.esguerra10
 */
public class ApiKeyProperties extends Properties {
    
    private static final String ID_PROP = "apiKey.id";
    private static final String SECRET_PROP = "apiKey.secret";

    public ApiKeyProperties() {
        super.put(ID_PROP, System.getenv("MODEL_STORMPATH_API_KEY_ID"));
        super.put(SECRET_PROP, System.getenv("MODEL_STORMPATH_API_KEY_SECRET"));
    }
    
    public String getApiKeyId(){
        return this.getProperty(ID_PROP);
    }
    
    public String getApiKeySecret(){
        return this.getProperty(SECRET_PROP);
    }
}
