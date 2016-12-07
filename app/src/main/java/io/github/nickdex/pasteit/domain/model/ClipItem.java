/*
 * Copyright © 2016 Nikhil Warke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.nickdex.pasteit.domain.model;

/**
 * Model class to represent a clip item.
 */
public final class ClipItem {

    public static final String INVALID = "NOT A PHONE";

    private String text;
    private Device deviceType;
    private String senderEmail;
    private long timestamp;
    private String deviceName;

    public ClipItem() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeviceName() {
        if (deviceType != Device.PHONE) return INVALID;
        else
            return deviceName;
    }

    public void setDeviceName(String deviceName) {
        if (this.deviceType != Device.PHONE) this.deviceName = INVALID;
        else
            this.deviceName = deviceName;
    }

    public Device getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(Device deviceType) {
        this.deviceType = deviceType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}

