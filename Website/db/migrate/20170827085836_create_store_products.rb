class CreateStoreProducts < ActiveRecord::Migration[5.1]
  def change
    create_table :store_products do |t|
    	t.references :store, index: true, foreign_key: true
    	t.references :product, index: true, foreign_key: true
    	t.integer		 :in_stock, null: false, default: 0

      t.timestamps
    end
  end
end
