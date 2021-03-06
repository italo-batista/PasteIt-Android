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

package io.github.nickdex.pasteit.copy;

import android.content.ClipData;
import android.content.ClipboardManager;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

/**
 * Listens to clipboard for new items and sends it to service.
 */
public class ClipBoardManager {

    private ClipboardManager clipboard;

    public ClipBoardManager(ClipboardManager manager) {
        clipboard = manager;
    }

    /**
     * Returns latest clip's text data.
     *
     * @return Returns latest clip's text data, empty string if data is null.
     */
    public String getClip() {
        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

        return item.getText().toString();
    }

    public void setClip(String text) {
        ClipData clipData = ClipData.newPlainText(MIMETYPE_TEXT_PLAIN, text);
        clipboard.setPrimaryClip(clipData);
    }
}

