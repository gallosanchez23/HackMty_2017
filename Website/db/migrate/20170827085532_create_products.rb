class CreateProducts < ActiveRecord::Migration[5.1]
  def change
    create_table :products do |t|
    	t.string  :name, null: false, default: ''
    	t.integer :cost, null: false, default: 0
    	t.string	:bars_code, null: false

      t.timestamps
    end
  end
end
