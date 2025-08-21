CREATE TABLE "Users"(
    "id" INTEGER NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL UNIQUE,
    "password_hash" VARCHAR(255) NOT NULL,
    "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "update_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "delete_at" TIMESTAMP(0) WITHOUT TIME ZONE NULL
);
ALTER TABLE
    "Users" ADD PRIMARY KEY("id");
CREATE TABLE "Comments"(
    "id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "post_id" INTEGER NOT NULL,
    "comment" TEXT NOT NULL,
    "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "update_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "delete_at" TIMESTAMP(0) WITHOUT TIME ZONE NULL
);
ALTER TABLE
    "Comments" ADD PRIMARY KEY("id");
CREATE TABLE "Posts"(
    "id" INTEGER NOT NULL,
    "user_id" INTEGER NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "description" TEXT NOT NULL,
    "photo" VARCHAR(255) NOT NULL,
    "create_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "update_at" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "delete_at" TIMESTAMP(0) WITHOUT TIME ZONE NULL
);
ALTER TABLE
    "Posts" ADD PRIMARY KEY("id");
ALTER TABLE
    "Posts" ADD CONSTRAINT "posts_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Users"("id");
ALTER TABLE
    "Comments" ADD CONSTRAINT "comments_post_id_foreign" FOREIGN KEY("post_id") REFERENCES "Posts"("id");
ALTER TABLE
    "Comments" ADD CONSTRAINT "comments_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "Users"("id");