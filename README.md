### 注册
> POST: WWW.example.com/user/register

##### 志愿者注册

| 参数 		| 值 	|
| ----------- | ------ |
| name		  | 姓名   | 
| phone		  | 手机号，登录名 |
| idNumber    | 身份证号 |
| school      | 学校   |
| educationBg | 最高学历，如本科生，研究生 |
| password    | 密码 |
| role		  | 3    |
##### 机构注册

| 参数	| 值 |
| ------ | ------- |
| name    | 机构名 |
| province | 省  |
| city     | 市  |
| county   | 县  | 
| idNumber | 机构号，登录名 |
| phone    | 联系电话 |
| password | 密码 |
| role 	| 2 |

##### 需求学校注册
| 参数 | 值 |
| ---- | --- |
| name | 学校名 |
| province | 省  |
| city     | 市  |
| county   | 县  | 
| phone    | 联系电话,登录名 |
| password | 密码 |
| description | 学校描述 |
| role | 1 | 

- 返回数据

``` json
{
	"status": 1,
    "msg": "OK",
    "data": null
}

{
	"status": -1,
    "msg": "...",
    "data": null
}

```
### 登录
> POST: www.example.com/user/login

| 参数 | 值 |
| --- | --- |
| username | 登录名 |
| password | 密码 |

- 返回数据

``` json
// 登录成功
{
	"status": 1,
    "msg": "OK",
    "data: {
    	"id": 1,
        "role": 3,
        "name": "武汉理工大学"
    }
}


// 登录失败
{
	"status": -1,
    "msg": "pwd_wrong",
    "data": null
}


```


### 发布需求
>POST: www.example.com/demside/task

| 参数 | 值 |
| --- | --- |
| title | 标题 |
| ddlRegister | 报名截至时间戳 |
| startTime | 支教开始时间戳 | 
| peopleNeed | 需要人数 |
| description | 需求内容 |
| imgUrl | 描述需求的图片的链接，多个图片图片以&#124;分开 |
| lastDays | 志愿者至少要支教的时间 |