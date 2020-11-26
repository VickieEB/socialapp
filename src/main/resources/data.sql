-- noinspection SqlDialectInspectionForFile
insert into location values (1, 'New York');
insert into location values (2, 'New Zealand');
commit;
insert into user values(1, 'rico@gmail.com', 'Rico', 'Bulus', 1);
insert into user values(2, 'coco@gmail.com', 'Coco', 'Bulus', 2);
insert into user values(3, 'lara@gmail.com', 'Lara', 'Oshodi', 2);
insert into user values(4, 'jane@gmail.com', 'Jane', 'Okoh', 2);
commit;
insert into post values(1, 'I really do not like dry food, donno why my human just dont get it', '10-10-2020', 1);
insert into post values(2, 'Again with the dry food. I Love boiled Eggs, why cant she give me those?', '11-10-2020', 1);
insert into post values(3, 'I dont know why my brother Rico doesnt like dry food, its soooo yummy!', '10-10-2020', 2);
insert into post values(4, 'I Love how much food Rico can eat at a time and how he is always ready to eat #Sasha', '18-06-2020', 3);
insert into post values(5, 'Cats are the cutest #CatLover', '18-06-2020', 3);
insert into post values(6, 'I hate Cats, i dont know why Lara and Vickie keeps gushing over them creatures #RollsEyes', '21-06-2020', 4);

commit;
