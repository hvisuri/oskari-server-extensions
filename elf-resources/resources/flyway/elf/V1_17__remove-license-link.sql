DELETE FROM portti_view_bundle_seq WHERE bundle_id = (SELECT id FROM portti_bundle WHERE name = 'elf-license');

DELETE FROM portti_bundle WHERE name = 'elf-license';