- `@NotNull`：指定字段不能为空。
- `@NotEmpty`：指定**列表**字段不能为空。
- `@NotBlank`：指定字符串字段不得为空或仅包含空格。
- `@Min` 和 `@Max`：指定数字字段的最小值和最大值。
- `@Pattern`：指定字符串字段必须匹配的正则表达式模式。
- `@Email`：指定字符串字段必须是有效的电子邮件地址。
- `@AssertFalse` 限制必须为false
- `@AssertTrue` 限制必须为true
- `@DecimalMax(value)` 限制必须为一个不大于指定值的数字
- `@DecimalMin(value)` 限制必须为一个不小于指定值的数字
- `@Digits(integer,fraction)` 限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
- `@Email` 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
- `@Future `限制必须是一个将来的日期
- `@FutureOrPresent` 未来或当前的日期，此处的present概念是相对于使用约束的类型定义的。例如校验的参数为Year year = Year.now();此时约束是一年，那么“当前”将表示当前的整个年份。
- `@Negative` 绝对的负数，不能包含零，空元素有效可以校验通过
- `@NegativeOrZero` 包含负数和零，空元素有效可以校验通过
- `@NotBlank` 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
- `@NotEmpty` 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）
- `@NotNull` 限制必须不为null
- `@Null` 限制只能为null
- `@Past` 限制必须是一个过去的日期
- `@PastOrPresent` 过去或者当前时间，和@FutureOrPresent类似
- `@Pattern(value) `限制必须符合指定的正则表达式
- `@Positive` 绝对的正数，不能包含零，空元素有效可以校验通过
- `@PositiveOrZero` 包含正数和零，空元素有效可以校验通过
- `@Size(max,min)` 限制字符长度必须在min到max之间

针对入参是List的请求，们需要使用自定义的 List 集合来接收参数，即包装 List 类型，并声明 @Valid 注解。

使用@Delegate委托List

问题：
1. 为什么在src/main/java/com/zcw/springvalidationdemo/controller/ListController.java中方法入参出使用分组校验管用；
2. 在src/main/java/com/zcw/springvalidationdemo/controller/AfterLocalDateController.java只能把@Vailator放在COntroller上才可以？

解决：src/main/java/com/zcw/springvalidationdemo/pojo/VaildatorList.java该List上忘记加上@Data了，没有生成getter、setter


