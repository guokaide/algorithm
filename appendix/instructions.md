# 上传与更新本地代码到Github

1. 远程操作：
   * Github上创建Repo
2. 本地操作：
   * git clone https://github.com/guokaide/leetcode
   * cd leetcode
   * git init
   * git add .
   * git remote add origin https://github.com/guokaide/leetcode  （将本地仓库与远程关联）
   * git commit -m "update all files"
   * git pull origin master  (将remote所有的操作更新到本地，避免local与remote冲突)
   * git push -u origin master
3. 注：核心更新操作
   * git status
   * git add *
   * git commit -m "comments"
   * git pull origin master
   * git push origin master

