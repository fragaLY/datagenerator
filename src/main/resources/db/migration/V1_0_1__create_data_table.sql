SET SEARCH_PATH TO DATAGEN;

CREATE TABLE DATA
(
    id                    bigserial             NOT NULL,
    data                  jsonb                 DEFAULT NULL,
    created               timestamp             NOT NULL,

    CONSTRAINT "pk_domain_data.data" PRIMARY KEY (id)
);