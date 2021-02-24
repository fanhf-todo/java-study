package com.fanhf.javastudy.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

import static org.junit.jupiter.api.Assertions.*;

class QRCodeUtilTest {

    @Test
    void getCodeByte() {
        String snowflakeMd5 = DigestUtils.md5Hex(
                String.format("%s|%s|%s","123456",
                        RandomStringUtils.randomAlphanumeric(20),
                        "15894663826"));
        try {
            byte[] qrcode = QRCodeUtil.getCodeByte("FHF_" + snowflakeMd5);
            String loginQrcode = "data:image/png;base64," + Base64Utils.encodeToString(qrcode);
            System.out.println("loginQrcode:" + loginQrcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}