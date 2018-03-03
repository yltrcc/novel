/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.ttxxly.novel.entity;


import java.util.List;

import top.ttxxly.novel.base.Base;

/**
 * @author yuyh.
 * @date 2016/8/4.
 */
public class HotWord extends Base {


    private List<String> hotWords;
    private List<NewHotWordsBean> newHotWords;

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }

    public List<NewHotWordsBean> getNewHotWords() {
        return newHotWords;
    }

    public void setNewHotWords(List<NewHotWordsBean> newHotWords) {
        this.newHotWords = newHotWords;
    }


    public static class NewHotWordsBean {
        /**
         * word : 影帝的老婆
         * book : 57a6c7d7ac9f894d54a3be42
         */

        private String word;
        private String book;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }
    }
}
