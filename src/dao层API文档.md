
1.根据给的id获取相应的类的函数

a.获取音乐
定义
public static Music getMusicFromDB(int music_id);
参数
int music_id 音乐的ID
返回值
一个Music类型对象

b.获取用户
定义
public static User getUserFromDB(int user_id)
参数
int user_id 用户的ID
返回值
一个User对象

c.获取小组
定义
public static Group getGroupFromDB(int group_id)
参数
int group_id 小组的ID 
返回值 
一个Group对象

d.获取项目
定义
public static Project getProjectFromDB(int project_id)
参数
int project_id 项目的ID
返回值
一个Project类型对象



2.获取整个站推荐的小组，返回推荐的小组个数和Group[]的对象数组，数组里面放推荐的小组



3.获取音乐评论
定义
public static Comment getMusic_comments(int music_id,int num,int type);
参数
int num 第几条评论 int type 排序类型，0 表示按热度（点赞数）排序，1 表示按时间排序
返回值
一个Comment类型对象



4.获取相似音乐
定义
public static Music[] getLikes(int music_id,int num);
参数
int music_id 音乐的id,int num 相似音乐的数目
返回值
一个Music类型对象的数组，里面是几首相似的音乐


5.获取group的project
定义
public static Project[] getGroupProjectFromDB(int group_id)
根据group_id查询小组的project
参数
int group_id
返回值
一个Project类型的数组，里面是小组的项目
