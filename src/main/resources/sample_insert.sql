-- Insert sample addresses
INSERT INTO address (full_address) VALUES 
('123 Main Street, New York, NY 10001'),
('456 Oak Avenue, Los Angeles, CA 90210'),
('789 Pine Road, Chicago, IL 60601');

-- Insert sample employees
INSERT INTO employee (first_name, last_name, email, contact, address_id, job_title, dob, joining_date) VALUES 
('John', 'Smith', 'john.smith@company.com', '+1-555-0101', 1, 'Senior Software Engineer', '1990-05-15', '2022-03-01'),
('Sarah', 'Johnson', 'sarah.johnson@company.com', '+1-555-0102', 2, 'HR Manager', '1988-09-22', '2021-07-15'),
('Michael', 'Brown', 'michael.brown@company.com', '+1-555-0103', 3, 'Product Manager', '1985-12-10', '2020-11-30');

-- Insert sample jobs
INSERT INTO job (job_title, compensation, posted_by, hiring_manager, job_description) VALUES 
('Frontend Developer', 85000, 1, 2, 'We are looking for a skilled Frontend Developer to join our team. Must have experience with React, JavaScript, and modern CSS frameworks.'),
('Data Analyst', 75000, 2, 3, 'Seeking a detail-oriented Data Analyst to help drive business decisions through data insights. Experience with SQL, Python, and data visualization tools required.'),
('UX Designer', 80000, 3, 2, 'Join our design team as a UX Designer. Create intuitive user experiences and collaborate with product and engineering teams. Portfolio required.');