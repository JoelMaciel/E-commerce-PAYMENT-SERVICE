CREATE TABLE IF NOT EXISTS `transaction_details` (
  `transaction_id` CHAR(36) PRIMARY KEY,
  `order_id` CHAR(36) NOT NULL,
  `payment_mode` VARCHAR(20) NOT NULL,
  `reference_number` VARCHAR(50) UNIQUE,
  `payment_date` DATETIME NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `amount` DECIMAL(10,2) NOT NULL,

  UNIQUE (transaction_id)
);
