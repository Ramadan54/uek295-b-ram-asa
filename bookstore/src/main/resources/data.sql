
INSERT INTO book (book_id, title, language, price) VALUES
('11111111-1111-1111-1111-111111111111', 'Clean Code', 'English', 45.90),
('22222222-2222-2222-2222-222222222222', 'Java für Einsteiger', 'German', 39.95),
('33333333-3333-3333-3333-333333333333', 'Spring Boot in Action', 'English', 55.50)
ON CONFLICT DO NOTHING;
INSERT INTO "order" (order_id, status, comment, date) VALUES
('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Pending', 'Customer will pay later', 20250401),
('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Shipped', 'Priority order', 20250402),
('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Delivered', 'Delivered on time', 20250403)
ON CONFLICT DO NOTHING;
INSERT INTO book_order (book_id, order_id) VALUES
('11111111-1111-1111-1111-111111111111', 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
('22222222-2222-2222-2222-222222222222', 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
('33333333-3333-3333-3333-333333333333', 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
('11111111-1111-1111-1111-111111111111', 'aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaaa')
ON CONFLICT DO NOTHING;