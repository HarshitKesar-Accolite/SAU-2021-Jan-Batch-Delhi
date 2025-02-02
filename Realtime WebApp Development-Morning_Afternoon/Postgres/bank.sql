PGDMP         ;                 y            bank    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16599    bank    DATABASE     `   CREATE DATABASE bank WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
    DROP DATABASE bank;
                postgres    false            �            1259    16605 
   currencies    TABLE     j   CREATE TABLE public.currencies (
    currency_serial_key integer NOT NULL,
    currency_amount integer
);
    DROP TABLE public.currencies;
       public         heap    postgres    false            �            1259    16612    transactions    TABLE     �   CREATE TABLE public.transactions (
    transaction_number integer NOT NULL,
    account_number integer,
    currency_serial_key integer,
    legal boolean
);
     DROP TABLE public.transactions;
       public         heap    postgres    false            �            1259    16610 #   transactions_transaction_number_seq    SEQUENCE     �   CREATE SEQUENCE public.transactions_transaction_number_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.transactions_transaction_number_seq;
       public          postgres    false    203            �           0    0 #   transactions_transaction_number_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.transactions_transaction_number_seq OWNED BY public.transactions.transaction_number;
          public          postgres    false    202            �            1259    16600    users    TABLE     g   CREATE TABLE public.users (
    username character varying(20),
    account_number integer NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            *           2604    16615    transactions transaction_number    DEFAULT     �   ALTER TABLE ONLY public.transactions ALTER COLUMN transaction_number SET DEFAULT nextval('public.transactions_transaction_number_seq'::regclass);
 N   ALTER TABLE public.transactions ALTER COLUMN transaction_number DROP DEFAULT;
       public          postgres    false    203    202    203            �          0    16605 
   currencies 
   TABLE DATA           J   COPY public.currencies (currency_serial_key, currency_amount) FROM stdin;
    public          postgres    false    201   �       �          0    16612    transactions 
   TABLE DATA           f   COPY public.transactions (transaction_number, account_number, currency_serial_key, legal) FROM stdin;
    public          postgres    false    203   �       �          0    16600    users 
   TABLE DATA           9   COPY public.users (username, account_number) FROM stdin;
    public          postgres    false    200   �       �           0    0 #   transactions_transaction_number_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.transactions_transaction_number_seq', 1, false);
          public          postgres    false    202            .           2606    16609    currencies currencies_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.currencies
    ADD CONSTRAINT currencies_pkey PRIMARY KEY (currency_serial_key);
 D   ALTER TABLE ONLY public.currencies DROP CONSTRAINT currencies_pkey;
       public            postgres    false    201            0           2606    16617    transactions transactions_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_number);
 H   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_pkey;
       public            postgres    false    203            ,           2606    16604    users users_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (account_number);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    200            1           2606    16618 -   transactions transactions_account_number_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_account_number_fkey FOREIGN KEY (account_number) REFERENCES public.users(account_number);
 W   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_account_number_fkey;
       public          postgres    false    2860    203    200            2           2606    16623 2   transactions transactions_currency_serial_key_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_currency_serial_key_fkey FOREIGN KEY (currency_serial_key) REFERENCES public.currencies(currency_serial_key);
 \   ALTER TABLE ONLY public.transactions DROP CONSTRAINT transactions_currency_serial_key_fkey;
       public          postgres    false    2862    203    201            �   $   x�3�0�450�2400�000��@"�\1z\\\ W�	      �      x�342�45136�4�0�,����� (��      �      x��H,*��45136����� +��     