CREATE TABLE "teams"(
    "id" INTEGER NOT NULL,
    "group_id" INTEGER NULL,
    "name_team" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "teams" ADD PRIMARY KEY("id");
ALTER TABLE
    "teams" ADD CONSTRAINT "teams_name_team_unique" UNIQUE("name_team");
CREATE TABLE "groups"(
    "id" INTEGER NOT NULL,
    "stages_id" INTEGER NOT NULL,
    "name_group" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "groups" ADD PRIMARY KEY("id");
ALTER TABLE
    "groups" ADD CONSTRAINT "groups_name_group_unique" UNIQUE("name_group");
CREATE TABLE "stages"(
    "id" INTEGER NOT NULL,
    "name_stage" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "stages" ADD PRIMARY KEY("id");
ALTER TABLE
    "stages" ADD CONSTRAINT "stages_name_stage_unique" UNIQUE("name_stage");
CREATE TABLE "matches"(
    "id" INTEGER NOT NULL,
    "home_team" INTEGER NOT NULL,
    "away_team" INTEGER NOT NULL,
    "home_score" INTEGER NOT NULL,
    "away_score" INTEGER NOT NULL,
    "result_id" INTEGER NOT NULL,
    "date_match" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "matches" ADD PRIMARY KEY("id");
CREATE TABLE "results"(
    "id" INTEGER NOT NULL,
    "name_result" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "results" ADD PRIMARY KEY("id");
ALTER TABLE
    "matches" ADD CONSTRAINT "matches_result_id_foreign" FOREIGN KEY("result_id") REFERENCES "results"("id");
ALTER TABLE
    "matches" ADD CONSTRAINT "matches_home_team_foreign" FOREIGN KEY("home_team") REFERENCES "teams"("id");
ALTER TABLE
    "teams" ADD CONSTRAINT "teams_group_id_foreign" FOREIGN KEY("group_id") REFERENCES "groups"("id");
ALTER TABLE
    "matches" ADD CONSTRAINT "matches_away_team_foreign" FOREIGN KEY("away_team") REFERENCES "teams"("id");
ALTER TABLE
    "groups" ADD CONSTRAINT "groups_stages_id_foreign" FOREIGN KEY("stages_id") REFERENCES "stages"("id");