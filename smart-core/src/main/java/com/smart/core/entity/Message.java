package com.smart.core.entity;

/**
 * 消息处理抽象类，支持默认处理，提供扩展支持
 * 注：国际化能力通过继承它实现，具体查看I18nMessage
 *
 * @author Joe
 */
public abstract class Message {

    /**
     * 定义默认实现
     */
    protected static final Message DEFAULT = new Message() {

        @Override
        public String getKey(String key, Object... args) {
            return args == null ? key : String.format(key, args);
        }
    };

    /**
     * 当前实例，可自定义通过setLocal()覆盖
     */
    private static Message local = DEFAULT;

    public void setLocal(Message message) {
        local = message;
    }

    public static String get(String key, Object... args) {
        return local.getKey(key, args);
    }

    public abstract String getKey(String key, Object... args);
}