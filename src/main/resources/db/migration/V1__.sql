CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime              NULL,
    updated_at datetime              NULL,
    is_deleted BIT(1)                NOT NULL,
    title      VARCHAR(255)          NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    datetime              NULL,
    updated_at    datetime              NULL,
    is_deleted    BIT(1)                NOT NULL,
    title         VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    price         DOUBLE                NOT NULL,
    image_url     VARCHAR(255)          NULL,
    category_id   BIGINT                NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);