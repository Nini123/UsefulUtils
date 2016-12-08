import java.util.Properties;

import com.google.common.base.Preconditions;

/**
 * {@link Properties}获取配置工具类
 *
 * @author xingtian
 * @since 0.9.9.4
 */
public final class PropertiesUtils {
    private PropertiesUtils() {
    }

    public static int getInteger(Properties props, String key, int defaultValue) {
        if (props.containsKey(key)) {
            String value = props.getProperty(key);
            try {
                int intValue = Integer.parseInt(value);
                Preconditions.checkArgument(intValue > 0, "The intValue of " + key + " must be more than 0!");
                return intValue;
            } catch (Exception e) {
                String message = "The value(" + value + ") for " + key + " is not valid!";
                throw new IllegalArgumentException(message, e);
            }
        }
        return defaultValue;
    }

    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        if (props.containsKey(key)) {
            String value = props.getProperty(key);
            if ("true".equalsIgnoreCase(value)) {
                return true;
            } else if ("false".equalsIgnoreCase(value)) {
                return false;
            } else {
                String message = "The value(" + value + ") for " + key + " is not valid!";
                throw new IllegalArgumentException(message);
            }
        }
        return defaultValue;
    }
}
