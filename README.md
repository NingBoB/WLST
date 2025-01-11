# 白名单过滤组件
使用aop实现的简单组件，后续可以扩展注册中心实时修改白名单配置
## 说明
项目中使用 DoJoinPoint 切面来实现，其使用方式有两种：
1. 配置扫描组件范围，扫描@ComponentScan(basePackages = {"com.dmm.middleware.*"})
2. 在配置类中将切入点配置为Bean对象
