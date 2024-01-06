CREATE TABLE Accounts(
    id SERIAL,
    name_account text,
    password_account text,
    words text[] is null,
    PRIMARY KEY(id)
);