-- INSERT INTO user_details VALUES(?, ?, ?, ?, NULL, NULL, NULL, NULL, ?)

-- SELECT email_address 
-- FROM user_details
-- WHERE email_address = ?

-- contact images join table query
SELECT contacts_table.full_name, user_details.user_profile_pic, 
	contacts_table.contact_owner_id 
FROM user_details
INNER JOIN contacts_table
ON contacts_table.contacts_acc_id = user_details.account_id

