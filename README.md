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
| schoolLevel | 学校级别，如初中，小学 |
| province | 省  |
| city     | 市  |
| county   | 县  | 
| address | 详细地址 |
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
>POST: www.example.com/task/task

| 参数 | 值 |
| --- | --- |
| title | 标题 |
| ddlRegister | 报名截至时间戳 |
| startTime | 支教开始时间戳 | 
| peopleNeed | 需要人数 |
| description | 需求内容 |
| imgUrl | 描述需求的图片的链接，多个图片图片以&#124;分开 |
| lastDays | 志愿者至少要支教的时间 |

### 获取需求列表
>GET: www.example.com/task/tasks

| 参数 | 值 |
| ---- | --- |
| page | 要看第几页? |
| pageSize | 一个页面的需求数 |
| province | 限制学校是哪个省，不含此参数则不限制 |
| schoolLevel | 限制学校级别，如中学,不含则不限制 |
| startTime | 需求创建时间最小时间戳，不含则不限制 |

- 返回数据
``` json
 {
    "msg": "OK",
    "code": 1,
    "data": [
        {
            "province": "湖北",
            "ddlRegister": "1559729180000",
            "city": "武汉",
            "createTime": "1559988380491",
            "county": "武汉",
            "name": "武汉理工",
            "id": 1,
            "title": "急需教师a"
        },
        {
            "province": "湖北",
            "ddlRegister": "2019.6.6",
            "city": "武汉",
            "createTime": "1559990038349",
            "county": "武汉",
            "name": "武汉理工",
            "id": 2,
            "title": "重庆酉阳山区书包公益支教志愿者招募"
        },
        {
            "province": "云南",
            "ddlRegister": "2019.6.9",
            "city": "昭通",
            "createTime": "1559990033969",
            "county": "彝良",
            "name": "大雄马子反",
            "id": 3,
            "title": "四川省凉山彝族自治州本木源助学支教志愿者招募"
        }
    ]
}
```

### 根据id获取需求
> GET: www.example.com/task/task?id=1
- 返回参数
``` json
{
    "msg": "OK",
    "code": 1,
    "data": {
        "province": "hubei",
        "ddlRegister": "1559729180000",
        "city": "wuhan",
        "phone": "17396178857",
        "county": "wuhan",
        "peopleNeed": 8,
        "description": "this is description",
        "schoolDes": "i am a 984.5"
    }
}
```

### 获取一个支教需求的志愿者
>GET: www.example.com/task/volunteers?taskId=7
- 返回数据 
``` json
成功:
{
    "msg": "OK",
    "code": 1,
    "data": [
        {
            "phone": "17396178857",
            "name": "武汉理工"
        },
        {
            "phone": "17396178857",
            "name": "wut"
        } 
    ]
}
志愿者数为0：
{
    "msg": "vol_empty",
    "code": "-1",
    "data": ""
}
```

### TODO

x1. 获取task列表
x2. 按条件塞选task。
  - 小学、中学？
  - province、city、county
  - startTime 

x// 任务接受情况表
4. 获取一个任务已经报名的人。
5. 获取一个人已经报名的任务。
// 
 x- taskId
 x- userId


6. 根据taskId获取task
