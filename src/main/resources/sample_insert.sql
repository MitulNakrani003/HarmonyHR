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

INSERT INTO departments (department_title, description, is_active) VALUES
('Software Engineering', 'Responsible for all software development, infrastructure, and quality assurance.', true),
('Human Resources', 'Manages recruitment, employee benefits, and company culture initiatives.', true),
('Sales', 'Drives revenue growth by acquiring new customers and managing client relationships.', true),
('Marketing', 'Drives revenue growth marketing and placing the product visible to consumers.', true);

-- Insert sample jobs
INSERT INTO job (job_title, posted_on, compensation, posted_by, hiring_manager, job_description, is_active, job_address, city, state, minimum_experience, maximum_experience, department_id) VALUES 
('Frontend Developer', '2025-08-10', 85000, 2, 1, 'We are seeking a talented Frontend Developer to join our engineering team. You will be responsible for creating responsive web applications using React, TypeScript, and modern CSS frameworks. Strong attention to detail and user experience is essential.', true, '123 Tech Plaza, Suite 400', 'San Francisco', 'CA', 2, 5, 1),
('Senior Backend Engineer', '2025-08-08', 120000, 2, 1, 'Looking for an experienced Backend Engineer to design and implement scalable microservices. Must have expertise in Node.js, Python, or Go, along with cloud platforms like AWS or GCP. You will mentor junior developers and architect solutions for high-traffic applications.', true, '456 Innovation Blvd', 'Austin', 'TX', 5, 10, 1),
('Recruitment Specialist', '2025-08-12', 65000, 2, 2, 'Join our HR team as a Recruitment Specialist! You will manage the full recruitment lifecycle, from sourcing candidates to conducting interviews. Experience with applicant tracking systems and talent acquisition strategies required.', true, '789 Corporate Center', 'Chicago', 'IL', 1, 3, 2),
('Sales Development Representative', '2025-08-14', 55000, 2, 3, 'Entry-level position perfect for someone starting their sales career. You will generate leads, qualify prospects, and set appointments for senior sales team members. Excellent communication skills and drive to succeed are must-haves.', true, '321 Business Park Dr', 'Denver', 'CO', 0, 2, 3),
('Account Executive', '2025-08-09', 95000, 2, 3, 'Experienced sales professional needed to manage enterprise client relationships. You will be responsible for closing deals, expanding existing accounts, and meeting quarterly revenue targets. Previous B2B software sales experience strongly preferred.', true, '654 Commerce Way', 'Seattle', 'WA', 3, 7, 3),
('Digital Marketing Manager', '2025-08-11', 78000, 2, 1, 'Lead our digital marketing efforts across multiple channels including social media, email campaigns, and content marketing. You will develop marketing strategies, analyze campaign performance, and collaborate with the product team to drive user acquisition.', true, '987 Marketing Plaza', 'Boston', 'MA', 2, 6, 4),
('DevOps Engineer', '2025-08-13', 110000, 2, 1, 'We need a skilled DevOps Engineer to manage our cloud infrastructure and CI/CD pipelines. Experience with Kubernetes, Docker, and infrastructure as code is required. You will ensure system reliability and optimize deployment processes.', true, '147 Cloud Street', 'Portland', 'OR', 3, 8, 1),
('Content Marketing Specialist', '2025-08-15', 62000, 2, 3, 'Creative individual needed to produce engaging content for our blog, social media, and email newsletters. You will research industry trends, write compelling copy, and work with the design team to create visual content that drives engagement.', true, '258 Creative Ave', 'Nashville', 'TN', 1, 4, 4);