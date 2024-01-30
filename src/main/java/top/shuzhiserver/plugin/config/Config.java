package top.shuzhiserver.plugin.config;

import cc.carm.lib.configuration.core.ConfigurationRoot;
import cc.carm.lib.configuration.core.annotation.HeaderComment;
import cc.carm.lib.configuration.core.value.type.ConfiguredList;
import cc.carm.lib.configuration.core.value.type.ConfiguredValue;

import java.util.ArrayList;
import java.util.List;

public class Config extends ConfigurationRoot {
    @HeaderComment("玩家加入事件,填写pass为不提示,填写其他为提示")
    public static final ConfiguredValue<String> PLAYERJOIN = ConfiguredValue.of(String.class,"default");
    @HeaderComment("vip")
    public static final ConfiguredList<String> VIP_LIST = ConfiguredList.of(String.class,"abc");
    @HeaderComment("玩家放置tnt时的ban原因,填写pass为放过,填写default为默认")
    public static final ConfiguredValue<String> PLACETNT = ConfiguredValue.of(String.class,"default");
    @HeaderComment("玩家睡觉时跳过夜晚的提示消息,填写pass为不跳过夜晚,填写default为默认")
    public static final ConfiguredValue<String> BEDENTER = ConfiguredValue.of(String.class,"default");
    @HeaderComment("菜单")
    public static class GUI extends ConfigurationRoot{
        @HeaderComment("是否启用")
        public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
        @HeaderComment("银行功能")
        public static final ConfiguredList<String> BANK = ConfiguredList.of(String.class);
        @HeaderComment("路径点")
        public static class WayPoints extends ConfigurationRoot{
            @HeaderComment("是否启用")
            public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
            public static class WayPoint1 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint2 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint3 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint4 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint5 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint6 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
            public static class WayPoint7 extends ConfigurationRoot{
                @HeaderComment("是否启用")
                public static final ConfiguredValue<Boolean> ENABLE = ConfiguredValue.of(Boolean.class,false);
                @HeaderComment("x坐标")
                public static final ConfiguredValue<Integer> X = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("y坐标")
                public static final ConfiguredValue<Integer> Y = ConfiguredValue.of(Integer.class,0);
                @HeaderComment("z坐标")
                public static final ConfiguredValue<Integer> Z = ConfiguredValue.of(Integer.class,0);
            }
        }
    }
}
