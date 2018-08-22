package com.emerchantpay.gateway.api.interfaces;

import com.emerchantpay.gateway.api.RequestBuilder;
import com.emerchantpay.gateway.api.validation.GenesisValidator;
import com.emerchantpay.gateway.api.validation.RequiredParameters;
import com.emerchantpay.gateway.api.validation.RequiredParametersValidator;
import com.emerchantpay.gateway.util.Country;

import java.util.HashMap;

/*
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @license http://opensource.org/licenses/MIT The MIT License
 */

public interface ShippingAddressAttributes {

    RequestBuilder requestBuilder = new RequestBuilder("");
    HashMap<String, String> paramsMap = new HashMap<String, String>();
    GenesisValidator validator = new GenesisValidator();

    // Shipping Address
    default ShippingAddressAttributes setShippingFirstname(String firstname) {
        paramsMap.put("first_name", firstname);
        requestBuilder.addElement("first_name", firstname);
        return this;
    }

    default ShippingAddressAttributes setShippingLastname(String lastname) {
        paramsMap.put("last_name", lastname);
        requestBuilder.addElement("last_name", lastname);
        return this;
    }

    default ShippingAddressAttributes setShippingPrimaryAddress(String primaryAddress) {
        paramsMap.put("address1", primaryAddress);
        requestBuilder.addElement("address1", primaryAddress);
        return this;
    }

    default ShippingAddressAttributes setShippingSecondaryAddress(String secondaryAddress) {
        paramsMap.put("address2", secondaryAddress);
        requestBuilder.addElement("address2", secondaryAddress);
        return this;
    }

    default ShippingAddressAttributes setShippingCity(String city) {
        paramsMap.put("city", city);
        requestBuilder.addElement("city", city);
        return this;
    }

    default ShippingAddressAttributes setShippingZipCode(String zipCode) {
        paramsMap.put("zip_code", zipCode);
        requestBuilder.addElement("zip_code", zipCode);
        return this;
    }

    default ShippingAddressAttributes setShippingState(String state) {
        paramsMap.put("state", state);
        requestBuilder.addElement("state", state);
        return this;
    }

    default ShippingAddressAttributes setShippingCountry(String country) {
        Country c = new Country();

        paramsMap.put("country", c.getIsoCode(country));
        requestBuilder.addElement("country", c.getIsoCode(country));

        return this;
    }

    default String getShippingFirstName() {
        return paramsMap.get("first_name");
    }

    default String getShippingLastName() {
        return paramsMap.get("last_name");
    }

    default String getShippingPrimaryAddress() {
        return paramsMap.get("address1");
    }

    default String getShippingSecondary() {
        return paramsMap.get("address2");
    }

    default String getShippingCity() {
        return paramsMap.get("city");
    }

    default String getShippingZipCode() {
        return paramsMap.get("zip_code");
    }

    default String getShippingState() {
        return paramsMap.get("state");
    }

    default String getShippingCountryCode() {
        return paramsMap.get("country");
    }

    default HashMap<String, String> getShippingAddressParams() {
        return paramsMap;
    }

    default RequestBuilder buildShippingAddress() {
        if (isShippingAddressValid()) {
            return requestBuilder;
        } else {
            return null;
        }
    }

    default Boolean isShippingAddressValid() {
        // Required params validator
        RequiredParameters requiredParameters = new RequiredParameters();
        RequiredParametersValidator requiredParametersValidator;

        // Init Required Params Validator
        requiredParametersValidator = new RequiredParametersValidator(requiredParameters
                .getRequiredParametersForAddress((AddressAttributes) this));

        return requiredParametersValidator.isValidRequiredParams();
    }
}