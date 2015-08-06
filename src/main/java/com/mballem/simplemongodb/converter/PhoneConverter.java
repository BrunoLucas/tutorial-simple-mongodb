package com.mballem.simplemongodb.converter;

import com.mballem.simplemongodb.entity.Phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 09/07/12
 * Time: 16:51
 * http://mballem.com/
 */
public class PhoneConverter {

    public Map<String, Object> converterToMap(Phone phone) {
        Map<String, Object> mapPhone = new HashMap<String, Object>();
        mapPhone.put("phoneNumber", phone.getPhoneNumber());
        mapPhone.put("mobileNumber", phone.getMobileNumber());

        return mapPhone;
    }

    public Phone converterToPhone(HashMap<String, Object> hashMap) {
        Phone phone = new Phone();
        phone.setPhoneNumber((String) hashMap.get("phoneNumber"));
        phone.setMobileNumber((String) hashMap.get("mobileNumber"));
        return phone;
    }
}
