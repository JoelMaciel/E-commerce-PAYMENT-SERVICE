set foreign_key_checks = 0;

delete from transaction_details;

set foreign_key_checks = 1;



INSERT INTO transaction_details (transaction_id, order_id, payment_mode, reference_number, payment_date, status, amount)
VALUES
  ('354eb533-9ef7-4490-92a7-c4fa6bdf6fa5', '2231c9a2-2a3b-4376-aed4-aa777e6af85a', 'CREDIT_CARD', '1234567890', '2023-07-20 12:00:00', 'APROVED', 100.00),
  ('662e9f2b-2376-4c5d-9ac0-f8a5b989808a', 'e22974b6-ab03-4f8a-b11d-2c470ee7987b', 'CASH', '9876543210', '2023-07-21 12:00:00', 'SUCCESS', 200.00),
  ('e117a4ef-9f18-49ec-a34a-ad18f9329129', '3e8ad87a-3284-4cb7-bc5f-dd7a7bab8c10', 'PAYPAL', '3210987654', '2023-07-22 12:00:00', 'CANCELED', 300.00);
