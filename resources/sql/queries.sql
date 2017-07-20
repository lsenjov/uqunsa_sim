-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO users
(id, first_name, last_name, email, pass)
VALUES (:id, :first_name, :last_name, :email, :pass)

-- :name update-user! :! :n
-- :doc update an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- :name get-user :? :1
-- :doc retrieve a user given the id.
SELECT * FROM users
WHERE id = :id

-- :name delete-user! :! :n
-- :doc delete a user given the id
DELETE FROM users
WHERE id = :id


--------------------
-- Regions
--------------------
-- :name create-region! :! :n
-- :doc Adds a region to the table
INSERT INTO regions
(id, name, regionx, regiony, object)
VALUES (:id, :name, :regionx, :regiony, :object)
ON DUPLICATE KEY UPDATE id = :id;

-- :name get-all-regions
-- :doc Returns all regions
SELECT * FROM regions;

-- :name get-region
-- :doc Gets a region by either id or name
SELECT * FROM regions
WHERE (id = :search)
OR (name LIKE :search);

