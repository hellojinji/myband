# service层API文档

## 获取音乐getMusic()

### 定义
public static Music getMusic(int music_id)
### 参数
int music_id 音乐的ID
### 返回值
一个Music类型对象

## 获取用户getUser()

### 定义
public static User getUser(int user_id)
### 参数
int user_id 用户的ID
### 返回值
一个User对象

## 获取小组getGroup()

### 定义
public static Group getGroup(int group_id)
### 参数
int group_id 小组的ID
###返回值
一个Group对象

## 获取项目getProject()

### 定义
public static Project getProject(int project_id)
### 参数
int project_id 项目的ID
### 返回值
一个Project类型对象

## 获取推荐小组getRecommandGroup()

### 定义
public static Group[] getRecommandGroup(int num)
### 参数
int num 获取推荐小组的数量
### 返回值
Group类型数组

## 获取音乐的某条评论getMusicComment()

### 定义
public static Comment getMusicComment(int music_id,int num,int type)
### 参数
int music_id 音乐ID
int num 第几条评论
int type 排序类型，0表示按热度（点赞数）排序，1表示按时间排序
### 返回值
Comment类型对象

## 获取相似音乐getFamiliarMusic()

### 定义
public static Music[] getFamiliarMusic(int music_id,int num)
### 参数
int music_id 音乐ID
int num 获取相似音乐的数量
### 返回值
Music数组
### 补充
根据音乐的风格找相似音乐

