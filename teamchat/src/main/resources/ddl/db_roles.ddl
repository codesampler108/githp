drop role if exists 'appdev','appread','appwrite';
create role 'appdev','appread','appwrite';
grant all on teamchatdb.* to 'appdev';
grant select on teamchatdb.* to 'appread';
grant select,insert,update,delete on teamchatdb.* to 'appwrite';