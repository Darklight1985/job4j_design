create view show_students_and_count_of_book_Pushkin
as select s.name as студенты, a.name as автор, count(b.id) as книг_шт
from students as s
 join orders o on s.id = o.student_id
 join books b on o.book_id = b.id
 join authors a on b.author_id = a.id
 group by (s.name,a.name)
 having a.name = 'Александр Пушкин' 
 order by count(b.id) desc;