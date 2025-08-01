PGDMP      4                }            literalura_db    17.5    17.5     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16585    literalura_db    DATABASE     �   CREATE DATABASE literalura_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE literalura_db;
                     postgres    false            �            1259    16586    autores    TABLE     �   CREATE TABLE public.autores (
    id bigint NOT NULL,
    ano_falecimento integer,
    ano_nascimento integer,
    nome character varying(255)
);
    DROP TABLE public.autores;
       public         heap r       postgres    false            �            1259    16589    autores_id_seq    SEQUENCE     w   CREATE SEQUENCE public.autores_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.autores_id_seq;
       public               postgres    false    217            �           0    0    autores_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.autores_id_seq OWNED BY public.autores.id;
          public               postgres    false    218            �            1259    16590    livros    TABLE     �   CREATE TABLE public.livros (
    id bigint NOT NULL,
    downloads integer,
    idioma character varying(255),
    titulo character varying(255),
    autor_id bigint
);
    DROP TABLE public.livros;
       public         heap r       postgres    false            �            1259    16595    livros_id_seq    SEQUENCE     v   CREATE SEQUENCE public.livros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.livros_id_seq;
       public               postgres    false    219            �           0    0    livros_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.livros_id_seq OWNED BY public.livros.id;
          public               postgres    false    220            &           2604    16596 
   autores id    DEFAULT     h   ALTER TABLE ONLY public.autores ALTER COLUMN id SET DEFAULT nextval('public.autores_id_seq'::regclass);
 9   ALTER TABLE public.autores ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    218    217            '           2604    16597 	   livros id    DEFAULT     f   ALTER TABLE ONLY public.livros ALTER COLUMN id SET DEFAULT nextval('public.livros_id_seq'::regclass);
 8   ALTER TABLE public.livros ALTER COLUMN id DROP DEFAULT;
       public               postgres    false    220    219            �          0    16586    autores 
   TABLE DATA           L   COPY public.autores (id, ano_falecimento, ano_nascimento, nome) FROM stdin;
    public               postgres    false    217   l       �          0    16590    livros 
   TABLE DATA           I   COPY public.livros (id, downloads, idioma, titulo, autor_id) FROM stdin;
    public               postgres    false    219   b       �           0    0    autores_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.autores_id_seq', 8, true);
          public               postgres    false    218            �           0    0    livros_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.livros_id_seq', 10, true);
          public               postgres    false    220            )           2606    16599    autores autores_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.autores
    ADD CONSTRAINT autores_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.autores DROP CONSTRAINT autores_pkey;
       public                 postgres    false    217            -           2606    16601    livros livros_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT livros_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.livros DROP CONSTRAINT livros_pkey;
       public                 postgres    false    219            /           2606    16603 #   livros uk_g3f1axgwlo51736qi31me3ylx 
   CONSTRAINT     `   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT uk_g3f1axgwlo51736qi31me3ylx UNIQUE (titulo);
 M   ALTER TABLE ONLY public.livros DROP CONSTRAINT uk_g3f1axgwlo51736qi31me3ylx;
       public                 postgres    false    219            +           2606    16605 $   autores uk_nm3lqihf39ftusc2plavv9hmj 
   CONSTRAINT     _   ALTER TABLE ONLY public.autores
    ADD CONSTRAINT uk_nm3lqihf39ftusc2plavv9hmj UNIQUE (nome);
 N   ALTER TABLE ONLY public.autores DROP CONSTRAINT uk_nm3lqihf39ftusc2plavv9hmj;
       public                 postgres    false    217            0           2606    16606 "   livros fkmjvs91l0cqtg1hy9kfj3b40fy    FK CONSTRAINT     �   ALTER TABLE ONLY public.livros
    ADD CONSTRAINT fkmjvs91l0cqtg1hy9kfj3b40fy FOREIGN KEY (autor_id) REFERENCES public.autores(id);
 L   ALTER TABLE ONLY public.livros DROP CONSTRAINT fkmjvs91l0cqtg1hy9kfj3b40fy;
       public               postgres    false    219    217    4649            �   �   x��;n�0D��)x !�ʒB��WN�O����$,h�R ]')R�2r^,K7ۼ����-��M[�{Gg/�F[�罣^T�J!�
�!�),�3��B�`�(V�t�y[���AnF���[���LQ�-��i�n�&��5g�4V0nT	�g.�ӟ�����7f�z�T�_ix�cG��\�袸g�Y���B׾����Ô���=ofߥ� T�ʺu��$]y�1�P^:�	!��]Q�      �   2  x�%NKn�0]�O1(vHB����*�����q�!XMl�OU�Su�)r��t5O��U�-�dߑ�ÝU�&4G\��� ��(:�a�[�+�e��)'/�>�N��(=���L�dPNO�Y��?��x���ò�ڪ�4^�"�Ϋր`9��(aw��;�FbC8��[���΍��gk�A7#����7b���ޏ6�;�E�0�}!cTe>M�[���VF?V�r��� �BC%LX	"�x�<;\7\�$9�/x����q.]�5P�
x%D"^�:���Ǹ#-�Io�d||,���퍃){�g���xO     