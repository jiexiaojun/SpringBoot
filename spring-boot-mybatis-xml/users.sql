if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.users')
            and   type = 'U')
   drop table dbo.users
go

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table dbo.users (
   id                   bigint               identity,
   userName             varchar(30)          null,
   passWord             varchar(30)          null,
   user_sex             varchar(30)          null,
   nick_name            varchar(30)          null,
   constraint PK_USERS primary key (id)
)
go

execute sp_addextendedproperty 'MS_Description',  
   '用户表', 
   'schema', 'dbo', 'table', 'users'
go

execute sp_addextendedproperty 'MS_Description', 
   '主键ID',
   'schema', 'dbo', 'table', 'users', 'column', 'id'
go

execute sp_addextendedproperty 'MS_Description', 
   '用户名',
   'schema', 'dbo', 'table', 'users', 'column', 'userName'
go

execute sp_addextendedproperty 'MS_Description', 
   '密码',
   'schema', 'dbo', 'table', 'users', 'column', 'passWord'
go

execute sp_addextendedproperty 'MS_Description', 
   '性别',
   'schema', 'dbo', 'table', 'users', 'column', 'user_sex'
go

execute sp_addextendedproperty 'MS_Description', 
   '昵称',
   'schema', 'dbo', 'table', 'users', 'column', 'nick_name'
go


