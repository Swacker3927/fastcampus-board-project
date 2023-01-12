INSERT INTO article (title, content, created_at, created_by, modified_at, modified_by)
values ('Test', 'test', now(), 'tester', now(), 'tester');
INSERT INTO article_comment (article_id, content, created_at, created_by, modified_at, modified_by)
values (1, 'test', now(), 'tester', now(), 'tester');
