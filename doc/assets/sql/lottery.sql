create database lottery;

-- auto-generated definition
create table activity
(
    id            bigint auto_increment comment 'self-increment id',
    activityId    bigint       null comment 'activity id',
    activityName  varchar(64)  not null comment 'activity name',
    activityDesc  varchar(128) null comment 'activity description',
    beginDateTime datetime     not null comment 'begin time',
    endDateTime   datetime     not null comment 'end time',
    stockCount    int          not null comment 'stock count',
    takeCount     int          null comment 'take count per user',
    state         int          null comment 'activity state：Edit, Arraign, Withdraw, Pass, Run, Reject, Close, Open',
    creator       varchar(64)  not null comment 'creator',
    createTime    datetime     not null comment 'create time',
    updateTime    datetime     not null comment 'update time',
    constraint activity_id_uindex
        unique (id)
)
    comment 'activity config';

alter table activity
    add primary key (id);

-- auto-generated definition
create table award
(
    id           bigint(11) auto_increment comment 'auto increment id'
        primary key,
    awardId      bigint                             null comment 'award id',
    awardType    int(4)                             null comment 'type of award : text descriptions, redemption codes, coupons, physical prizes not available at this time',
    awardCount   int                                null comment 'award count',
    awardName    varchar(64)                        null comment 'award name',
    awardContent varchar(128)                       null comment 'award content',
    createTime   datetime default CURRENT_TIMESTAMP null comment 'create time',
    updateTime   datetime default CURRENT_TIMESTAMP null comment 'update time',
)
    comment 'award config';

-- auto-generated definition
create table strategy
(
    id           bigint(11) auto_increment comment 'auto increment id'
        primary key,
    strategyId   bigint(11)   not null comment 'strategy id',
    strategyDesc varchar(128) null comment 'strategy description',
    strategyMode int(4)       null comment 'strategy mode: 1: individual probability, 2: overall probability',
    grantType    int(4)       null comment 'grant type: 1: immediate, 2: delayed',
    grantDate    datetime     null comment 'grant date',
    extInfo      varchar(128) null comment 'ext info',
    createTime   datetime     null comment 'create time',
    updateTime   datetime     null comment 'update time',
    constraint strategy_strategyId_uindex
        unique (strategyId)
)
    comment 'strategy config';

-- auto-generated definition
create table strategy_detail
(
    id         bigint(11) auto_increment comment 'auto increment id'
        primary key,
    strategyId bigint(11)    not null comment 'strategy id',
    awardId    bigint(11)    null comment 'award id',
    awardCount int           null comment 'award count',
    awardRate  decimal(5, 2) null comment 'award rate',
    createTime datetime      null comment 'create time',
    updateTime datetime      null comment 'update time',
)
    comment 'strategy detail';
