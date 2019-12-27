package com.wenyu7980.el;
/**
 * Copyright wenyu
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

import java.io.ByteArrayInputStream;

/**
 * 表达式语言
 * @author:wenyu
 * @date:2019/12/25
 */
public final class ExpressionLanguages {
    private ExpressionLanguages() {
    }

    /**
     * 解析
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parse(String text, Class<T> clazz) {
        return parse(text, new ElContext(), clazz);
    }

    /**
     * 解析
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parse(String text, ElContext context, Class<T> clazz) {
        ExpressionLanguageParser parser = new ExpressionLanguageParser(
                new ByteArrayInputStream(text.getBytes()));
        try {
            return (T) parser.statement(context);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
